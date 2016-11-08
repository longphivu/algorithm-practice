package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 8, 2016
 * Problem:		Q152_MaximumProductSubarray.java
 * Source:		https://leetcode.com/problems/maximum-product-subarray/
 *
 * Description:	 Find the contiguous subarray within an array (containing at least one number) which has the largest product.
				For example, given the array [2,3,-2,4],
				the contiguous subarray [2,3] has the largest product = 6. 
 *
 * Solution:	2 pointer, calculate product till meet '0',
 * Complexity:	O(2n)
 * Notes:		Aware of '0' case
 *				
 * Follow up:	
 */
public class Q152_MaximumProductSubarray {
	public int maxProduct(int[] nums) {

		int low = 0, high = 0;
		int aws = nums[0];
		int product = 1;
		while (high < nums.length) {
			while (high < nums.length && nums[high] != 0) {
				product *= nums[high];
				high++;
				aws = Math.max(aws, product);
			}
			while (low < high) {
				product /= nums[low];
				if (low != high - 1) // skip the last [high] to avoid divine by
										// itself
					aws = Math.max(aws, product);
				low++;
			}
			// high stop at 0 or arr length
			if (high < nums.length && nums[high] == 0) {
				high++;
				low++;
				aws = Math.max(0, aws);
				product = 1;
			}
		}

		return aws;
	}
}
