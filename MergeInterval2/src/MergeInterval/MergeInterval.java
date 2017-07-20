package MergeInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Make sure the returned intervals are also sorted.

A : [ (1, 2), (3, 6) ]
B : (8, 10)
(1, 2) (3, 6) (8, 10) 

A : [ (6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999), (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097) ]
B : (36210193, 61984219)

(6037774, 6198243) (6726550, 7004541) (8842554, 10866536) (11027721, 11341296) (11972532, 14746848) (16374805, 16706396) (17557262, 20518214) (22139780, 22379559) (27212352, 28404611) (28921768, 29621583) (29823256, 32060921) (33950165, 64859907) (65277782, 65296274) (67497842, 68386607) (70414085, 73339545) (73896106, 75605861) (79672668, 84539434) (84821550, 86558001) (91116470, 92198054) (96147808, 98979097
 */


// Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
public class MergeInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> outArr = new ArrayList<Interval>();
		
		for (int i = 0; i < intervals.size(); i++) {
			Interval inputInt = intervals.get(i);
			if(inputInt.start <= newInterval.start) {
				//check if the newInterval andn inputInterval overlap or not
				//if true merge should take place.
				if(newInterval.start <= inputInt.end) { //overlap case (1,4)(2,5) --> (1,5)
					Interval outInterval = new Interval();
					outInterval.start = inputInt.start;
					outInterval.end = (inputInt.end > newInterval.end) ? inputInt.end : newInterval.end;
					outArr.add(outInterval); //add the merged Interval 
				}
				else { // if the input interval and newInterval don't overlap (1,2)(4,5) --> (1,2)(4,5)
					if((i == intervals.size() -1) && (newInterval.start > inputInt.end)) { // add the new interval in the end
						//add the new interval also
						outArr.add(inputInt);
						outArr.add(newInterval);
					}
					else if((i > 0) && (intervals.get(i-1).end < newInterval.start) && (newInterval.start < inputInt.start)) {// add the new interval in the mid
						outArr.add(newInterval);
						outArr.add(inputInt);
					}
					outArr.add(inputInt);
				}
			}
			else { //(4,7)(1,3) --> (1,3)(4,7)
				if(!outArr.isEmpty()) {
					Interval lastInterval = outArr.remove(outArr.size() -1);
					if((lastInterval.start <= newInterval.start) && (newInterval.start <= lastInterval.end)) {
						Interval outInterval = new Interval();
						outInterval.start = lastInterval.start;
						outInterval.end = (lastInterval.end > newInterval.end) ? lastInterval.end : newInterval.end;
						outArr.add(outInterval);
					}
					else {
						outArr.add(lastInterval);
						outArr.add(newInterval);
					}
				}
				else {
					outArr.add(newInterval);
					outArr.add(inputInt);
				}
			}
		}
	
    	return outArr;
    }
    
    public String toString(Interval intr) {
		return intr.start + " " + intr.end;
    }
    
}

class Solution {
	public static void main(String[] args) {
		MergeInterval mrg = new MergeInterval();
		// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
		ArrayList<Interval> inputArr = new ArrayList<Interval>();
		inputArr.add(new Interval(1,2));
		inputArr.add(new Interval(3,5));
		inputArr.add(new Interval(6,7));
		inputArr.add(new Interval(8,10));
		inputArr.add(new Interval(12,16));
		
		Interval newInterval = new Interval(4,9);
		System.out.println(inputArr);
		//mrg.insert(inputArr, newInterval);
	}
}
