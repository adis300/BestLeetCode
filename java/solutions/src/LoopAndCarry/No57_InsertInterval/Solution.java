package LoopAndCarry.No57_InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 */
public class Solution {

    private class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> result = new ArrayList<>();
        /* will fall through the while loop.
        if (intervals.isEmpty()){
            result.add(newInterval);
            return result;
        }*/

        int i = 0;
        Interval interval;
        boolean inserted = false;
        // Work on first half.
        while (i < intervals.size()){
            interval = intervals.get(i++);
            if (interval.end >= newInterval.start){
                if (interval.start <= newInterval.start || newInterval.end >= interval.start){
                    newInterval.end = Math.max(interval.end, newInterval.end);
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    result.add(newInterval);
                    inserted = true;
                    break;
                }
                // no overlap insert in between and return
                intervals.add(i - 1, newInterval);
                return intervals;
            }
            result.add(interval);
        }

        if (!inserted){
            result.add(newInterval);
            return result;
        }

        //things in between to be merged
        while (i < intervals.size()){
            interval = intervals.get(i++);
            if (interval.start > newInterval.end) result.add(interval);
            else newInterval.end = Math.max(interval.end, newInterval.end);
        }
        return result;
    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) return new ArrayList<>(Arrays.asList(newInterval));

        int i = 0;
        boolean inserted = false;
        do {
            Interval interval = intervals.get(i);
            if (interval.end >= newInterval.start) {
                if (interval.start <= newInterval.start) intervals.add(i+1, newInterval);
                else intervals.add(i, newInterval);
                inserted = true;
                break;
            }
            ++i;
        }while(i < intervals.size());

        if (!inserted){
            intervals.add(newInterval);
            return intervals;
        }

        // Now i is the target insert index. and the new interval has been inserted
        int j = i;
        Interval nextInterval, thisInterval;
        while (j < intervals.size() - 1){
            thisInterval = intervals.get(j);
            nextInterval = intervals.get(j + 1);
            if (nextInterval.start <= thisInterval.end){
                // merge this with next and remove next
                thisInterval.end = Math.max(thisInterval.end, nextInterval.end);
                intervals.remove(j + 1);
            }else break;
        }

        return intervals;

    }

}
