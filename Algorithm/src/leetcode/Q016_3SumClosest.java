package leetcode;

import java.util.Arrays;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 1, 2016
 * Problem:		Q16_3SumClosest.java
 * Source:		https://leetcode.com/problems/3sum-closest/
 *
 * Description:	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
			    For example, given array S = {-1 2 1 -4}, and target = 1.
			    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Solution:	k sum problem, sort first then go k-1 loop 
 * Complexity:	O(n^2)
 * Notes:		might have overflow
 *				
 * Follow up:	(M) 3Sum Smaller  
 */
public class Q016_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closest = Integer.MAX_VALUE;
        int ret = 0;
        for(int f = 0; f<nums.length; f++){
            int l = f+1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[f]+nums[l]+nums[r];
                int diff = Math.abs(target - sum);
                if(diff < closest){
                    ret = sum;
                    closest = diff;
                }
                if(sum > target)
                    r--;
                else
                    l++;
            }
        }
        
        return ret;
    }
}
