package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jan 12, 2017
 * Problem:		Q287_FindDuplicateNumber.java
 * Source:		https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Description:	Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * 				prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * 				find the duplicate one.
				Note:
				    You must not modify the array (assume the array is read only).
				    You must use only constant, O(1) extra space.
				    Your runtime complexity should be less than O(n2).
				    There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * Solution:	PigeonHole Principle; Binary Search idea, select [mid] from [1, n] = [lo, hi] 
 * 				then count how many numbers that less than or equal [mid], if the count greater than [mid], refine the range to [mid+1, hi] else [lo, mid]
 * Complexity:	O(nlogn)
 * Notes:		O(n) solution: http://keithschwarz.com/interesting/code/?dir=find-duplicate
 *				
 * Follow up:	
 */
public class Q287_FindDuplicateNumber {

	public static int findDuplicate(int[] nums) {
        int lo = 1;
        int hi = nums.length;
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
        
            int count = 0;
            for (int n : nums)
                if (n <= mid) count++;
            if (count > mid)
                hi = mid;
            else 
                lo = mid + 1;
        }
        return lo;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,5,5,5,5,5,5};
		System.out.println(findDuplicate(arr));

	}

}
