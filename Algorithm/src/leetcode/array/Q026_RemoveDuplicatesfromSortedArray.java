package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 8, 2016
 * Problem:		Q26_RemoveDuplicatesfromSortedArray.java
 * Source:		https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Description:	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
				Do not allocate extra space for another array, you must do this in place with constant memory. 
				For example,
				 Given input array nums = [1,1,2], 
				Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
 *
 * Solution:	2 pointers
 * Complexity:  O(n)
 * Notes:
 *				
 * Follow up:	(H) Trapping Rain Water   (E) Intersection of Two Arrays II   (M) Sort Transformed Array  
 */
public class Q026_RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int distinctIndex = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[distinctIndex++] = nums[i];
			}
		}
		
		return distinctIndex;
	}
}
