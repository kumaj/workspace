/* 
 * Copyright 2001-2009 Terracotta, Inc. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 */
package org.quartz.simpl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.jobs.NoOpJob;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;

/**
 * Unit test for RAMJobStore.  These tests were submitted by Johannes Zillmann
 * as part of issue QUARTZ-306.
 * 
 * Updated more test case in dealing with QRTZ-202 by Zemian Deng.
 */
public class RAMJobStoreTest extends TestCase {
    private JobStore fJobStore;
    private JobDetailImpl fJobDetail;
    private SampleSignaler fSignaler;

    protected void setUp() throws Exception {
        this.fJobStore = new RAMJobStore();
        this.fSignaler = new SampleSignaler();
        this.fJobStore.initialize(null, this.fSignaler);

        this.fJobDetail = new JobDetailImpl("job1", "jobGroup1", NoOpJob.class);
        this.fJobDetail.setDurability(true);
        this.fJobStore.storeJob(this.fJobDetail, false);
    }

    public void testAcquireNextTrigger() throws Exception {
        OperableTrigger trigger1 = 
            new SimpleTriggerImpl("trigger1", "triggerGroup1", this.fJobDetail.getName(), 
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 200000), 
                    new Date(System.currentTimeMillis() + 200000), 2, 2000);
        OperableTrigger trigger2 = 
            new SimpleTriggerImpl("trigger2", "triggerGroup1", this.fJobDetail.getName(), 
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() - 100000),
                    new Date(System.currentTimeMillis() + 20000), 2, 2000);
        OperableTrigger trigger3 = 
            new SimpleTriggerImpl("trigger1", "triggerGroup2", this.fJobDetail.getName(), 
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 100000), 
                    new Date(System.currentTimeMillis() + 200000), 2, 2000);

        trigger1.computeFirstFireTime(null);
        trigger2.computeFirstFireTime(null);
        trigger3.computeFirstFireTime(null);
        this.fJobStore.storeTrigger(trigger1, false);
        this.fJobStore.storeTrigger(trigger2, false);
        this.fJobStore.storeTrigger(trigger3, false);

        assertTrue(this.fJobStore.acquireNextTriggers(10, 1, 1L).isEmpty());
        assertEquals(
            trigger2, 
            this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0));
        assertEquals(
            trigger3, 
            this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0));
        assertEquals(
            trigger1, 
            this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0));
        assertTrue(
            this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).isEmpty());

        // because of trigger2
        assertEquals(1, this.fSignaler.fMisfireCount);

        // release trigger3
        this.fJobStore.releaseAcquiredTrigger(trigger3);
        assertEquals(
            trigger3, 
            this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0));
    }

    public void testAcquireNextTriggerBatch() throws Exception {
        OperableTrigger trigger1 =
            new SimpleTriggerImpl("trigger1", "triggerGroup1", this.fJobDetail.getName(),
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 200000),
                    new Date(System.currentTimeMillis() + 200000), 2, 2000);
        OperableTrigger trigger2 =
            new SimpleTriggerImpl("trigger2", "triggerGroup1", this.fJobDetail.getName(),
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 200100),
                    new Date(System.currentTimeMillis() + 200100), 2, 2000);
        OperableTrigger trigger3 =
            new SimpleTriggerImpl("trigger3", "triggerGroup1", this.fJobDetail.getName(),
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 200200),
                    new Date(System.currentTimeMillis() + 200200), 2, 2000);
        OperableTrigger trigger4 =
            new SimpleTriggerImpl("trigger4", "triggerGroup1", this.fJobDetail.getName(),
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 200300),
                    new Date(System.currentTimeMillis() + 200300), 2, 2000);

        OperableTrigger trigger10 =
            new SimpleTriggerImpl("trigger10", "triggerGroup2", this.fJobDetail.getName(),
                    this.fJobDetail.getGroup(), new Date(System.currentTimeMillis() + 500000),
                    new Date(System.currentTimeMillis() + 700000), 2, 2000);

        trigger1.computeFirstFireTime(null);
        trigger2.computeFirstFireTime(null);
        trigger3.computeFirstFireTime(null);
        trigger4.computeFirstFireTime(null);
        trigger10.computeFirstFireTime(null);
        this.fJobStore.storeTrigger(trigger1, false);
        this.fJobStore.storeTrigger(trigger2, false);
        this.fJobStore.storeTrigger(trigger3, false);
        this.fJobStore.storeTrigger(trigger4, false);
        this.fJobStore.storeTrigger(trigger10, false);

        assertEquals(3, this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 3, 1000L).size());
        this.fJobStore.releaseAcquiredTrigger(trigger1);
        this.fJobStore.releaseAcquiredTrigger(trigger2);
        this.fJobStore.releaseAcquiredTrigger(trigger3);

        assertEquals(4, this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 4, 1000L).size());
        this.fJobStore.releaseAcquiredTrigger(trigger1);
        this.fJobStore.releaseAcquiredTrigger(trigger2);
        this.fJobStore.releaseAcquiredTrigger(trigger3);
        this.fJobStore.releaseAcquiredTrigger(trigger4);

        assertEquals(4, this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 10000, 5, 1000L).size());
        this.fJobStore.releaseAcquiredTrigger(trigger1);
        this.fJobStore.releaseAcquiredTrigger(trigger2);
        this.fJobStore.releaseAcquiredTrigger(trigger3);
        this.fJobStore.releaseAcquiredTrigger(trigger4);

        assertEquals(1, this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 0, 5, 0L).size());
        this.fJobStore.releaseAcquiredTrigger(trigger1);

        assertEquals(2, this.fJobStore.acquireNextTriggers(new Date(trigger1.getNextFireTime().getTime()).getTime() + 150, 5, 0L).size());
        this.fJobStore.releaseAcquiredTrigger(trigger1);
        this.fJobStore.releaseAcquiredTrigger(trigger2);
    }

    public void testTriggerStates() throws Exception {
        OperableTrigger trigger = 
            new SimpleTriggerImpl("trigger1", "triggerGroup1", this.fJobDetail.getName(), this.fJobDetail.getGroup(), 
                    new Date(System.currentTimeMillis() + 100000), new Date(System.currentTimeMillis() + 200000), 2, 2000);
        trigger.computeFirstFireTime(null);
        assertEquals(TriggerState.NONE, this.fJobStore.getTriggerState(trigger.getKey()));
        this.fJobStore.storeTrigger(trigger, false);
        assertEquals(TriggerState.NORMAL, this.fJobStore.getTriggerState(trigger.getKey()));
    
        this.fJobStore.pauseTrigger(trigger.getKey());
        assertEquals(TriggerState.PAUSED, this.fJobStore.getTriggerState(trigger.getKey()));
    
        this.fJobStore.resumeTrigger(trigger.getKey());
        assertEquals(TriggerState.NORMAL, this.fJobStore.getTriggerState(trigger.getKey()));
    
        trigger = this.fJobStore.acquireNextTriggers(
                new Date(trigger.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0);
        assertNotNull(trigger);
        this.fJobStore.releaseAcquiredTrigger(trigger);
        trigger=this.fJobStore.acquireNextTriggers(
                new Date(trigger.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).get(0);
        assertNotNull(trigger);
        assertTrue(this.fJobStore.acquireNextTriggers(
                new Date(trigger.getNextFireTime().getTime()).getTime() + 10000, 1, 1L).isEmpty());
    }

    // See: http://jira.opensymphony.com/browse/QUARTZ-606
    public void testStoreTriggerReplacesTrigger() throws Exception {

        String jobName = "StoreTriggerReplacesTrigger";
        String jobGroup = "StoreTriggerReplacesTriggerGroup";
        JobDetailImpl detail = new JobDetailImpl(jobName, jobGroup, NoOpJob.class);
        fJobStore.storeJob(detail, false);
 
        String trName = "StoreTriggerReplacesTrigger";
        String trGroup = "StoreTriggerReplacesTriggerGroup";
        OperableTrigger tr = new SimpleTriggerImpl(trName ,trGroup, new Date());
        tr.setJobKey(new JobKey(jobName, jobGroup));
        tr.setCalendarName(null);
 
        fJobStore.storeTrigger(tr, false);
        assertEquals(tr,fJobStore.retrieveTrigger(tr.getKey()));
 
        try {
            fJobStore.storeTrigger(tr, false);
            fail("an attempt to store duplicate trigger succeeded");
        } catch(ObjectAlreadyExistsException oaee) {
            // expected
        }

        tr.setCalendarName("QQ");
        fJobStore.storeTrigger(tr, true); //fails here
        assertEquals(tr, fJobStore.retrieveTrigger(tr.getKey()));
        assertEquals( "StoreJob doesn't replace triggers", "QQ", fJobStore.retrieveTrigger(tr.getKey()).getCalendarName());
    }

    public void testPauseJobGroupPausesNewJob() throws Exception
    {
    	final String jobName1 = "PauseJobGroupPausesNewJob";
    	final String jobName2 = "PauseJobGroupPausesNewJob2";
    	final String jobGroup = "PauseJobGroupPausesNewJobGroup";
    
    	JobDetailImpl detail = new JobDetailImpl(jobName1, jobGroup, NoOpJob.class);
    	detail.setDurability(true);
    	fJobStore.storeJob(detail, false);
    	fJobStore.pauseJobs(GroupMatcher.groupEquals(jobGroup));
    
    	detail = new JobDetailImpl(jobName2, jobGroup, NoOpJob.class);
    	detail.setDurability(true);
    	fJobStore.storeJob(detail, false);
    
    	String trName = "PauseJobGroupPausesNewJobTrigger";
    	String trGroup = "PauseJobGroupPausesNewJobTriggerGroup";
    	OperableTrigger tr = new SimpleTriggerImpl(trName, trGroup, new Date());
        tr.setJobKey(new JobKey(jobName2, jobGroup));
    	fJobStore.storeTrigger(tr, false);
    	assertEquals(TriggerState.PAUSED, fJobStore.getTriggerState(tr.getKey()));
    }
    
    public void testStoreAndRetrieveJobs() throws Exception {
		RAMJobStore store = new RAMJobStore();
		
		// Store jobs.
		for (int i=0; i < 10; i++) {
			JobDetail job = JobBuilder.newJob(NoOpJob.class).withIdentity("job" + i).build();
			store.storeJob(job, false);
		}
		// Retrieve jobs.
		for (int i=0; i < 10; i++) {
			JobKey jobKey = JobKey.jobKey("job" + i);
			JobDetail storedJob = store.retrieveJob(jobKey);
			Assert.assertEquals(jobKey, storedJob.getKey());
		}
	}
	
	public void testStoreAndRetriveTriggers() throws Exception {
		RAMJobStore store = new RAMJobStore();
		
		// Store jobs and triggers.
		for (int i=0; i < 10; i++) {
			JobDetail job = JobBuilder.newJob(NoOpJob.class).withIdentity("job" + i).build();
			store.storeJob(job, true);
			SimpleScheduleBuilder schedule = SimpleScheduleBuilder.simpleSchedule();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("job" + i).withSchedule(schedule).forJob(job).build();
			store.storeTrigger((OperableTrigger)trigger, true);
		}
		// Retrieve job and trigger.
		for (int i=0; i < 10; i++) {
			JobKey jobKey = JobKey.jobKey("job" + i);
			JobDetail storedJob = store.retrieveJob(jobKey);
			Assert.assertEquals(jobKey, storedJob.getKey());
			
			TriggerKey triggerKey = TriggerKey.triggerKey("job" + i);
			Trigger storedTrigger = store.retrieveTrigger(triggerKey);
			Assert.assertEquals(triggerKey, storedTrigger.getKey());
		}
	}
	
	public void testAcquireTriggers() throws Exception {
		SchedulerSignaler schedSignaler = new SampleSignaler();
		ClassLoadHelper loadHelper = new CascadingClassLoadHelper();
		loadHelper.initialize();
		
		RAMJobStore store = new RAMJobStore();
		store.initialize(loadHelper, schedSignaler);
		
		// Setup: Store jobs and triggers.
		long MIN = 60 * 1000L;
		Date startTime0 = new Date(System.currentTimeMillis() + MIN); // a min from now.
		for (int i=0; i < 10; i++) {
			Date startTime = new Date(startTime0.getTime() + i * MIN); // a min apart
			JobDetail job = JobBuilder.newJob(NoOpJob.class).withIdentity("job" + i).build();
			SimpleScheduleBuilder schedule = SimpleScheduleBuilder.repeatMinutelyForever(2);
			OperableTrigger trigger = (OperableTrigger)TriggerBuilder.newTrigger().withIdentity("job" + i).withSchedule(schedule).forJob(job).startAt(startTime).build();
			
			// Manually trigger the first fire time computation that scheduler would do. Otherwise 
			// the store.acquireNextTriggers() will not work properly.
	        Date fireTime = trigger.computeFirstFireTime(null);
	        Assert.assertEquals(true, fireTime != null);
			
			store.storeJobAndTrigger(job, trigger);
		}
		
		// Test acquire one trigger at a time
		for (int i=0; i < 10; i++) {
			long noLaterThan = startTime0.getTime() + i * MIN;
			int maxCount = 1;
			long timeWindow = 0;
			List<OperableTrigger> triggers = store.acquireNextTriggers(noLaterThan, maxCount, timeWindow);
			Assert.assertEquals(1, triggers.size());
			Assert.assertEquals("job" + i, triggers.get(0).getKey().getName());
			
			// Let's remove the trigger now.
			store.removeJob(triggers.get(0).getJobKey());
		}
	}
	
	public void testAcquireTriggersInBatch() throws Exception {
		SchedulerSignaler schedSignaler = new SampleSignaler();
		ClassLoadHelper loadHelper = new CascadingClassLoadHelper();
		loadHelper.initialize();
		
		RAMJobStore store = new RAMJobStore();
		store.initialize(loadHelper, schedSignaler);
		
		// Setup: Store jobs and triggers.
		long MIN = 60 * 1000L;
		Date startTime0 = new Date(System.currentTimeMillis() + MIN); // a min from now.
		for (int i=0; i < 10; i++) {
			Date startTime = new Date(startTime0.getTime() + i * MIN); // a min apart
			JobDetail job = JobBuilder.newJob(NoOpJob.class).withIdentity("job" + i).build();
			SimpleScheduleBuilder schedule = SimpleScheduleBuilder.repeatMinutelyForever(2);
			OperableTrigger trigger = (OperableTrigger)TriggerBuilder.newTrigger().withIdentity("job" + i).withSchedule(schedule).forJob(job).startAt(startTime).build();
			
			// Manually trigger the first fire time computation that scheduler would do. Otherwise 
			// the store.acquireNextTriggers() will not work properly.
	        Date fireTime = trigger.computeFirstFireTime(null);
	        Assert.assertEquals(true, fireTime != null);
			
			store.storeJobAndTrigger(job, trigger);
		}
		
		// Test acquire batch of triggers at a time
		long noLaterThan = startTime0.getTime() + 10 * MIN;
		int maxCount = 7;
		long timeWindow = 0;
		List<OperableTrigger> triggers = store.acquireNextTriggers(noLaterThan, maxCount, timeWindow);
		Assert.assertEquals(7, triggers.size());
		for (int i=0; i < 7; i++) {
			Assert.assertEquals("job" + i, triggers.get(i).getKey().getName());
		}
	}

    
    public static class SampleSignaler implements SchedulerSignaler {
        int fMisfireCount = 0;

        public void notifyTriggerListenersMisfired(Trigger trigger) {
            fMisfireCount++;
        }

        public void signalSchedulingChange(long candidateNewNextFireTime) {
        }

        public void notifySchedulerListenersFinalized(Trigger trigger) {
        }

        public void notifySchedulerListenersJobDeleted(JobKey jobKey) {
        }
    }
}
