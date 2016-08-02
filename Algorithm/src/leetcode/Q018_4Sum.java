package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 13, 2016
 * Problem:		Q18_4Sum.java
 * Source:		
 *
 * Description:	
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * The solution set must not contain duplicate quadruplets. 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	A solution set is:
	[
	  [-1,  0, 0, 1],
	  [-2, -1, 1, 2],
	  [-2,  0, 0, 2]
	]
 *	
 * Solution:	typical kSum	
 * Complexity:	Time O(n^3)
 * Notes:		
 *					
 * Follow up:	(M) Minimum Path Sum   (M) Combination Sum III   (E) Shortest Word Distance  
 */
public class Q018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		int len = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (4 * nums[i] > target)
				break;

			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				int s = j + 1;
				int e = nums.length - 1;

				if (nums[i] + 3 * nums[j] > target)	  break;
				if (nums[i] + 3 * nums[len - 1] < target)  break;

				while (s < e) {
					if (sum + nums[s] + nums[e] < target) {
						s++;
					} else if (sum + nums[s] + nums[e] > target) {
						e--;
					} else {
						List<Integer> solution = new ArrayList<Integer>();
						solution.add(nums[i]);
						solution.add(nums[j]);
						solution.add(nums[s]);
						solution.add(nums[e]);
						solutions.add(solution);
						while (s < len - 2 && nums[s] == nums[s + 1])
							s++;
						while (e < len - 2 && nums[e] == nums[e - 1])
							e--;
						s++;
						e--;
					}

				}
				while (j < len - 2 && nums[j] == nums[j + 1])
					j++;
			}
			while (i < len - 2 && nums[i] == nums[i + 1])
				i++;
		}

		return solutions;
	}
}
