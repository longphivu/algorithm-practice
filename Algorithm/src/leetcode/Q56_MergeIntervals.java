package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import universal.Interval;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 1, 2016
 * Problem:		Q56_MergeIntervals.java
 * Source:		https://leetcode.com/problems/merge-intervals/
 *
 * Description:	Given a collection of intervals, merge all overlapping intervals.
				For example,
				 Given [1,3],[2,6],[8,10],[15,18],
				 return [1,6],[8,10],[15,18]. 
 *
 * Solution:	Sort list of intervals, then merge
 * Complexity:	O(nlogn)
 * Notes:		faster solution
 * 				https://discuss.leetcode.com/topic/50391/java-7-8-ms-beats-96-two-solutions-no-sorting-merges-intervals-on-the-fly-and-sorting-solution-with-two-pointers
 *				
 * Follow up:	(H) Insert Interval   (E) Meeting Rooms   (M) Meeting Rooms II  
 */
public class Q56_MergeIntervals {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public List<Interval> merge(List<Interval> intervals) {

		if (intervals == null || intervals.size() == 0)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start != i2.start)
					return Integer.compare(i1.start, i2.start);
				else
					return Integer.compare(i1.end, i2.end);
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		result.add(prev);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				if (curr.end > prev.end)
					prev.end = curr.end;
			} else {
				result.add(curr);
				prev = curr;
			}
		}

		return result;
	}
}
