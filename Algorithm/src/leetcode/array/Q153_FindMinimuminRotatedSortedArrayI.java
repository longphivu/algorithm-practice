package leetcode.array;

/**
 * Author: Long Vu, longvu.cs@outlook.com Date: Aug 19, 2016 Problem:
 * Q153_FindMinimuminRotatedSortedArrayI.java Source:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Description: Suppose a sorted array is rotated at some pivot unknown to you
 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the
 * minimum element. You may assume no duplicate exists in the array.
 *
 * 
 * Solution: Binary search for rotate index/point Complexity: O(logn) Notes:
 * 
 * Follow up: (H) Search in Rotated Sorted Array (H) Find Minimum in Rotated
 * Sorted Array II
 */
public class Q153_FindMinimuminRotatedSortedArrayI {
	public static void main(String[] agr) {
//		int[] nums = { 4, 4, 4, 4,4,4,4,4};
//		int[] nums = { 4, 4, 4, 4,5,1,2,4};
		int[] nums = {10,1,10,10,10};
		System.out.println(nums[findMin(nums)]);
	}

	public static int findMin(int[] nums) {
        return findRotatePoint(nums);
    }
    private static int findRotatePoint(int[] nums) {
        int hi = nums.length - 1;
        int lo = 0;
        int mid;
        
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return lo;
            mid = (lo + hi) >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                if (nums[lo] > nums[hi]) {
                    hi = mid;
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }
        
        return lo;
    }

}
