package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 8, 2016
 * Problem:		Q283_MoveZeroes.java
 * Source:		https://leetcode.com/problems/move-zeroes/
 *
 * Description:	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
				For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
				Note:
				1.You must do this in-place without making a copy of the array.
				2.Minimize the total number of operations.
				Credits:
				Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 *
 * Solution:	2 pointers
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Unique Paths   (M) Unique Paths II   (M) Majority Element II  
 */
public class Q283_MoveZeroes {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                if (nums[j] == 0) { //only swap to 0 element
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
            i++;
        }
    }
}
