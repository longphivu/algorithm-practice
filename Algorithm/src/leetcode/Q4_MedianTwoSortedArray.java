package leetcode;

/**
 * Author:		
 * Date:		Jul 19, 2016
 * Problem:		Q4_MedianTwoSortedArray.java
 * Source:		https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Description:	
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 * Solution:	- X Wang: This problem can be converted to the problem of finding kth element, k is (A's length + B' Length)/2.
 *				If any of the two arrays is empty, then the kth element is the non-empty array's kth element. 
 *				If k == 0, the kth element is the first element of A or B. 
 *				For normal cases(all other cases), we need to move the pointer at the pace of half of an array length to get log(n) time. 
 * Complexity:	O(logn)
 * Notes:
 *					
 * Follow up:	(M) Construct Binary Tree from Preorder and Inorder Traversal  (E) Intersection of Two Arrays II  (H) Russian Doll Envelopes
 */
public class Q4_MedianTwoSortedArray {

	public static void main(String[] args) {
		int[] a = {2};
		int[] b = {1,3,4};
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int lenA = nums1.length;
		int lenB = nums2.length;

		if (((lenA + lenB) & 1) == 1)
			return (double) findKth(nums1, nums2, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1);
		else
			return (findKth(nums1, nums2, (lenA + lenB) / 2, 0, lenA - 1, 0, lenB - 1)
					+ findKth(nums1, nums2, (lenA + lenB) / 2 - 1, 0, lenA - 1, 0, lenB - 1)) * 0.5;
	}

	
	private static int findKth(int[] a, int[] b, int k, int starta, int enda, int startb, int endb) {
		int lena = enda - starta + 1;
		int lenb = endb - startb + 1;

		//base case
		if (lena == 0)
			return b[startb + k];
		if (lenb == 0)
			return a[starta + k];
		if (k == 0) {
			return (a[starta] > b[startb]) ? b[startb] : a[starta];
		}

		int mida = lena * k / (lena + lenb); //prevent case that midb < 0
		int midb = k - 1 - mida; // aMid + bMid + 1 = k must be satisfied to be able to make the conclusions

		//make mida, midb to index points
		mida = starta + mida;
		midb = startb + midb;

		if (a[mida] < b[midb]) {
			k = k - (mida - starta + 1);
			starta = mida + 1;
			endb = midb;
		} else {
			k = k - (midb - startb + 1);
			startb = midb + 1;
			enda = mida;
		}

		return findKth(a, b, k, starta, enda, startb, endb);
	}
	
}
