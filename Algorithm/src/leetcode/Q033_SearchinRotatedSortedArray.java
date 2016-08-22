package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 22, 2016
 * Problem:		Q033_SearchinRotatedSortedArray.java
 * Source:		https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Description:	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
				(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
				You are given a target value to search. If found in the array return its index, otherwise return -1.
				You may assume no duplicate exists in the array.
 *
 * Solution:	Modified BinarySearch
 * Complexity:	O(logn)
 * Notes:		This solution won't work for array with duplicate elements
 *				
 * Follow up:	(H) Best Time to Buy and Sell Stock III   (M) Shortest Word Distance III   (E) Closest Binary Search Tree Value  
 */
public class Q033_SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivotIdx = findMinIdx(nums);
        // return pivotIdx;
        if (pivotIdx > 0 && nums[0] <= target && target <= nums[pivotIdx - 1])
            return search(nums, target, 0, pivotIdx-1);
        else
            return search(nums, target, pivotIdx, nums.length - 1);
    }
    private static int findMinIdx(int[] nums) {
        int hi = nums.length-1;
        int lo = 0;
        int mid;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return lo;
            mid = (lo + hi) >>> 1;
            if (nums[mid] < nums[hi]) { //[mid, hi] is sorted
                hi = mid;
            } else if (nums[lo] < nums[mid]) { //[lo, mid] is sorted, but [hi] is <= [lo]
                lo = mid + 1;            
            } else { //[lo] equal [mid] or [mid] equal [hi]
                if (nums[lo] > nums[hi])
                    lo = mid + 1;
                else  // [lo] == [mid] == [hi], pivot point/min can be anywhere between [lo, mid] or [mid, hi] 
                    lo++;
            }
        }
        return lo;
    }
    private static int search(int[] nums, int target, int from, int to) {
        int hi = to;
        int lo = from;
        int mid;
        while (lo <= hi) {
            mid = (lo+hi) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid-1;
            if (nums[mid] < target) lo = mid+1;
        }
        return -1;
    }
}
