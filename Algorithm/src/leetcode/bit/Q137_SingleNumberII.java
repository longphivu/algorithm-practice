package leetcode.bit;

/**
 * Author:		yfcheng - https://discuss.leetcode.com/user/yfcheng
 * Date:		Oct 31, 2016
 * Problem:		Q137_SingleNumberII.java
 * Source:		https://leetcode.com/problems/single-number-ii/
 *
 * Description:	Given an array of integers, every element appears three times except for one. Find that single one. 
				Note:
				 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 *
 * Solution:	count the number of 1 bit at bit nth in array of numbers, the total count must dividend by 3, if not, it's the single number
 * Complexity:	O(32n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q137_SingleNumberII {
	public int singleNumber(int[] nums) {
		int appearance = 3;
		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((nums[j] >> i) & 1) == 1) {
					count++;
					count %= appearance;
				}
			}

			if (count != 0) {
				ans = ans | (count << i);
			}
		}

		return ans;
	}
}
