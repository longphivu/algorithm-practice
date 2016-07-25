package leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 13, 2016
 * Problem:		Two Sum
 * Source:		https://leetcode.com/problems/two-sum/
 * 
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 * Solution:	Use map to store the next require number
 * Follow up:	(M) Two Sum II - Input array is sorted,   (E) Two Sum III - Data structure design  
 */
public class Q1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(nums[i])) {
				ret[0] = map.get(nums[i]);
				ret[1] = i;
				break;
			} else {
				map.put(complement, i);
			}
		}

		return ret;
	}
}
