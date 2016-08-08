package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 8, 2016
 * Problem:		Q80RemoveDuplicatesfromSortedArrayII.java
 * Source:		https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Description:	Follow up for "Remove Duplicates":
				What if duplicates are allowed at most twice?
				For example,
				 Given sorted array nums = [1,1,1,2,2,3], 
				Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. 
 *
 * Solution:	2 + 1 (for the start of the duplicated element) pointers
 * Complexity:  O(n)
 * Notes:
 *				
 * Follow up:	(M) Next Permutation   (M) Combination Sum   (M) Majority Element II  
 */
public class Q080RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);   
    }
    
    public int removeDuplicates(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int start = 0; //index of the first occur number
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                start = i;
                nums[j++] = nums[i];
            } else if (i - start + 1 <= k) { //the duplicate index must greater than k from start
                nums[j++] = nums[i];
            }
        }
        
        return j;
    }
}
