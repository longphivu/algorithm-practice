package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q053_MaximumSubarray.java
 * Source:		https://leetcode.com/problems/maximum-subarray/
 *
 * Description:	 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
				For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
				the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	If you have figured out the O(n) solution, 
 * 				try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Q053_MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums.length < 1) return 0;
        
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i<nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
   }
}
