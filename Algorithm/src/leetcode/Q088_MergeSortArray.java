package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 1, 2016
 * Problem:		Q88_MergeSortArray.java
 * Source:		https://leetcode.com/problems/merge-sorted-array/
 *
 * Description:	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
				Note:
				 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * Solution:	start merging from the end of array
 * Complexity:	O(n+m)
 * Notes:
 *				
 * Follow up:	(M) Minimum Path Sum   (H) Longest Consecutive Sequence   (M) Product of Array Except Self  
 */
public class Q088_MergeSortArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n -1;
        n--;
        m--;
        while (k >= 0) {
            if (m < 0 || (n >= 0 && nums1[m] < nums2[n])) {
                nums1[k--] = nums2[n--];
            } else {
                nums1[k--] = nums1[m--];
            }
        }
    }
}
