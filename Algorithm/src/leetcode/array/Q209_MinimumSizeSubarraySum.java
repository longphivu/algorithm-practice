package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 2, 2016
 * Problem:		Q209_MinimumSizeSubarraySum.java
 * Source:		https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Description:	Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum >= s. 
 * 				If there isn't one, return 0 instead. 
				For example, given the array [2,3,1,2,4,3] and s = 7,
				 the subarray [4,3] has the minimal length under the problem constraint. 
 *
 * Solution:	2 pointers to mark the left and right boundaries of the sliding window
 * Complexity:	O(n)
 * Notes:		If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *				
 * Follow up:	
 */
public class Q209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int min = Integer.MAX_VALUE;
		int start = 0, end = 0;
		int sum = nums[0];
		while (start <= end && end < nums.length) {
			if (sum >= s) {
				min = Math.min(min, end - start + 1);
				sum -= nums[start++];
			} else if (sum < s && end < nums.length - 1)
				sum += nums[++end];
			else // end has reach the end of the array
				break;

		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
