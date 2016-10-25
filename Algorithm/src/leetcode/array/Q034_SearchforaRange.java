package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 19, 2016
 * Problem:		Q034_SearchforaRange.java
 * Source:		https://leetcode.com/problems/search-for-a-range/
 *
 * Description:	Given a sorted array of integers, find the starting and ending position of a given target value.
				Your algorithm's runtime complexity must be in the order of O(log n).
				If the target is not found in the array, return [-1, -1].
				For example,
				 Given [5, 7, 7, 8, 8, 10] and target value 8,
				 return [3, 4]. 
 *
 * Solution:	modify BinarySearch
 * Complexity:	O(logn)
 * Notes:
 *				
 * Follow up:	(E) First Bad Version  
 */
public class Q034_SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int[] range = new int[2];
		range[0] = findRange(nums, target, true);
		range[1] = findRange(nums, target, false);
		return range;
	}

	private static int findRange(int[] nums, int target, boolean lowerBound) {
		int hi = nums.length - 1;
		int lo = 0;
		int mid;
		while (hi >= lo) {
			mid = (hi + lo) >>> 1;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else if (nums[mid] > target) {
				hi = mid - 1;
			} else {
				if (lowerBound) {
					if (mid == 0 || nums[mid - 1] < target)
						return mid;
					hi = mid - 1;
				} else {
					if (mid == nums.length - 1 || nums[mid + 1] > target)
						return mid;
					lo = mid + 1;
				}
			}
		}
		return -1;
	}
}
