package SortForBenefit.No56_MergeIntervals;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for an interval.
 *
 */
public class Solution {

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        Interval interval = intervals.get(0);

        for (Interval item : intervals) {

            if(item.start > interval.end){

                result.add(interval);
                interval = item;

            }else interval.end = Math.max(interval.end, interval.end);

        }

        // Add the last interval
        result.add(interval);
        return result;
    }
}