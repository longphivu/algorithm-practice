package leetcode.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 25, 2016
 * Problem:		Q377_CombinationSumIV.java
 * Source:		https://leetcode.com/problems/combination-sum-iv/
 *
 * Description:	Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *				nums = [1, 2, 3]
				target = 4
				The possible combination ways are:
				(1, 1, 1, 1)
				(1, 1, 2)
				(1, 2, 1)
				(1, 3)
				(2, 1, 1)
				(2, 2)
				(3, 1)
				Note that different sequences are counted as different combinations.
				Therefore the output is 7.
 * Solution:	DP
 * Complexity:
 * Notes:
 * Follow up:	What if negative numbers are allowed in the given array?
				How does it change the problem?
				What limitation we need to add to the question to allow negative numbers? 
 */
public class Q377_CombinationSumIV {

	public static void main(String[] args) {
		int[] cans = {-3,2,1} ;
		int tar = 10;
		System.out.println(combinationSum4(cans, tar));

	}

	public static int combinationSum4(int[] nums, int target) {
    	if(nums == null || nums.length == 0)
            return 0;
     
        int[] dp = new int[target+1];
     
        dp[0] = 1;
     
        for (int i = 0; i <= target; i++) {
           for (int num : nums) {
               if (i+num <= target) {
                   dp[i+num] += dp[i];
               }
           }
        }
     
        return dp[target];

    }

}
