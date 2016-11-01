package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q041_FirstMissingPositive.java
 * Source:		https://leetcode.com/problems/first-missing-positive/
 *
 * Description:	Given an unsorted integer array, find the first missing positive integer.
				For example,
				Given [1,2,0] return 3,
				and [3,4,-1,1] return 2.
				Your algorithm should run in O(n) time and uses constant space. 
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q041_FirstMissingPositive {
	public int firstMissingPositive(int[] A) {

		int n = A.length;
		boolean[] track = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			int cur = A[i];
			if (cur > 0 && cur <= n) {
				track[cur] = true;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (track[i] == false)
				return i;
		}
		return n + 1;
	}
}
