package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 2, 2016
 * Problem:		Q27_RemoveElement.java
 * Source:		https://leetcode.com/problems/remove-element/
 *
 * Description:	Given an array and a value, remove all instances of that value in place and return the new length. 
				Do not allocate extra space for another array, you must do this in place with constant memory.
				The order of elements can be changed. It doesn't matter what you leave beyond the new length.
				Example:
				 Given input array nums = [3,2,2,3], val = 3 
				Your function should return length = 2, with the first two elements of nums being 2.
 *
 * Solution:	Use 2 pointers, swap to the end
 * Complexity:	O(n)
 * Notes:		Always aware of array index bounds
 *				
 * Follow up:	(E) Move Zeroes  
 */
public class Q027_RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else {
				i++;
			}
		}
		return n;
    }
}
