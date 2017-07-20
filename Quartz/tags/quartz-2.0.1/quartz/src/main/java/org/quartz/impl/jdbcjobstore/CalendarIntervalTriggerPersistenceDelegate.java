package org.quartz.impl.jdbcjobstore;

import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.ScheduleBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.spi.OperableTrigger;

public class CalendarIntervalTriggerPersistenceDelegate extends SimplePropertiesTriggerPersistenceDelegateSupport {

    public boolean canHandleTriggerType(OperableTrigger trigger) {
        return ((trigger instanceof CalendarIntervalTriggerImpl) && !((CalendarIntervalTriggerImpl)trigger).hasAdditionalProperties());
    }

    public String getHandledTriggerTypeDiscriminator() {
        return TTYPE_CAL_INT;
    }

    @Override
    protected SimplePropertiesTriggerProperties getTriggerProperties(OperableTrigger trigger) {

        CalendarIntervalTriggerImpl calTrig = (CalendarIntervalTriggerImpl)trigger;
        
        SimplePropertiesTriggerProperties props = new SimplePropertiesTriggerProperties();
        
        props.setInt1(calTrig.getRepeatInterval());
        props.setString1(calTrig.getRepeatIntervalUnit().name());
        props.setInt2(calTrig.getTimesTriggered());
        
        return props;
    }

    @Override
    protected TriggerPropertyBundle getTriggerPropertyBundle(SimplePropertiesTriggerProperties props) {

        ScheduleBuilder sb = CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
            .withInterval(props.getInt1(), IntervalUnit.valueOf(props.getString1()));
        
        int timesTriggered = props.getInt2();
        
        String[] statePropertyNames = { "timesTriggered" };
        Object[] statePropertyValues = { timesTriggered };

        return new TriggerPropertyBundle(sb, statePropertyNames, statePropertyValues);
    }

}
