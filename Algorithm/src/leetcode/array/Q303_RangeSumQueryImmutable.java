package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 16, 2016
 * Problem:		Q303_RangeSumQueryImmutable.java
 * Source:		https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Description:	Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.
				Note:
				1.You may assume that the array does not change.
				2.There are many calls to sumRange function.
 * Solution:	Prefix sum
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Range Sum Query 2D - Immutable   (M) Range Sum Query - Mutable   (M) Maximum Size Subarray Sum Equals k  
 */
public class Q303_RangeSumQueryImmutable {
	public class NumArray {

	    long[] pfSum;
	    
	    public NumArray(int[] nums) {
	        this.pfSum = new long[nums.length+1];
	        for (int i = 1; i < pfSum.length; i++) {
	            pfSum[i] = pfSum[i-1] + nums[i-1];
	        }
	    }

	    public int sumRange(int i, int j) {
	        return (int) (pfSum[j+1] - pfSum[i]); //prefix sum array shift one element to the right
	    }
	}


	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
