package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 22, 2016
 * Problem:		Q081_SearchinRotatedSortedArrayII.java
 * Source:		https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Description:	Follow up for "Search in Rotated Sorted Array":
				What if duplicates are allowed?
				Would this affect the run-time complexity? How and why?
				Write a function to determine if a given target is in the array.
 *
 * Solution:	Binary Search
 * Complexity:	O(logn) in average, O(n) in worst case scenario
 * Notes:
 *				
 * Follow up:	(H) Best Time to Buy and Sell Stock III   (M) Combination Sum III   (M) Valid Perfect Square  
 */
public class Q081_SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        int mid = -1;
        
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[hi]) { //[mid,hi] is sorted
                if (nums[mid] < target && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            } else if (nums[mid] > nums[hi]) { //[lo, mid] is sorted
                if (nums[lo] <= target && target < nums[mid]) 
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else { //[mid] == [hi]
                if (nums[lo] == nums[hi]) { // can't know which side is sorted
                    lo++;
                    hi--;
                } else { //[lo] > or < [hi] and since [mid] == [hi], [mid,hi] is same number, aka sorted
                    hi = mid - 1;
                }
            }
        }
        
        return false;
    }
}
