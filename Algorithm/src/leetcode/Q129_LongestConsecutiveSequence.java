package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 3, 2016
 * Problem:		Q129_LongestConsecutiveSequence.java
 * Source:		https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Description:	Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
				For example,
				 Given [100, 4, 200, 1, 3, 2],
				 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. 
				Your algorithm should run in O(n) complexity. 
 *
 * Solution:	Use set and find all the next left, then all next right number in the set.
 * Complexity:	O(n)
 * Notes:		Remove the visited number in the set so we don't have to check it again
 *				
 * Follow up:	(M) Binary Tree Longest Consecutive Sequence  
 */
public class Q129_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int max = 0;
		Set<Integer> set = new HashSet<Integer>();

		for (int n : nums) {
			set.add(n);
		}

		for (int n : nums) {
			int count = 1;
			int left = n - 1;
			int right = n + 1;
			set.remove(n);
			while (set.contains(left)) {
				set.remove(left);
				count++;
				left--;
			}
			while (set.contains(right)) {
				set.remove(right);
				count++;
				right++;
			}
			max = Math.max(max, count);
		}

		return max;
	}
}
