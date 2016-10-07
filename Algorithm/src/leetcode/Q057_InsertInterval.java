package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 1, 2016
 * Problem:		Q57_InsertInterval.java
 * Source:		https://leetcode.com/problems/insert-interval/
 *
 * Description:	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
				You may assume that the intervals were initially sorted according to their start times.
				Example 1:
				 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. 
				Example 2:
				 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. 
				This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 *
 * Solution:	3 cases, treat insert interval as previous interval
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Largest Rectangle in Histogram   (H) Maximal Rectangle   (E) Move Zeroes  
 */
public class Q057_InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() < 1) {
			intervals.add(newInterval);
			return intervals;
		}

		/*Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});*/

		List<Interval> result = new ArrayList<Interval>();
		result.add(newInterval);
		Interval prev = newInterval;
		int newIntervalIndex = 0;
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end < curr.start) { //case 1: on the left
				result.add(curr);
				prev = curr;
			} else if (prev.start > curr.end) { //case 2: on the right
				result.set(newIntervalIndex, curr);
				result.add(newInterval);
				newIntervalIndex++;
			} else { //case 3: partially or completely overlap
				prev.end = Math.max(curr.end, prev.end);
				prev.start = Math.min(curr.start, prev.start);
			}
		}

		return result;
	}
}
