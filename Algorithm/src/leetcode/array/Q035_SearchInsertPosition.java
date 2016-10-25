package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 3, 2016
 * Problem:		Q035_SearchInsertPosition.java
 * Source:		https://leetcode.com/problems/search-insert-position/
 *
 * Description:	Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
				You may assume no duplicates in the array.
 *
 * Solution:	Binary search
 * Complexity:	O(logn)
 * Notes:
 *				
 * Follow up:	(E) First Bad Version  
 */
public class Q035_SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.out.println(searchInsert(nums, 7));
	}

	public static int searchInsert(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		int mid = 0;
		while (high >= low) {
			mid = (high + low) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
				if (mid == nums.length - 1 || nums[mid + 1] >= target)
					return mid + 1;
			}
			if (nums[mid] >= target) {
				high = mid - 1;
			}
		}
		return 0;
	}
}
