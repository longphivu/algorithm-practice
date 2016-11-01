package leetcode.dp;

import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 8, 2016
 * Problem:		Q120_Triangle.java
 * Source:		https://leetcode.com/problems/triangle/
 *
 * Description:	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
				For example, given the following triangle
				[
				     [2],
				    [3,4],
				   [6,5,7],
				  [4,1,8,3]
				]
				The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 * Solution:	DP, calculate the minimum starting from the row next to bottom
 * Complexity:	O(n*m)
 * Notes:
 *				
 * Follow up:	(M) Unique Paths   (M) Wiggle Subsequence   (M) Combination Sum IV  
 */
public class Q120_Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		if (triangle.size() == 1)
			return triangle.get(0).get(0);

		int size = triangle.size();
		int[] dp = new int[size];
		
		for (int i = 0; i < size; i++) {
			dp[i] = triangle.get(size - 1).get(i);
		}

		List<Integer> cur;
		for (int level = size - 2; level >= 0; level--) { // start from the
														  // second last level
			cur = triangle.get(level);
			int prev = dp[level + 1];
			for (int i = cur.size() - 1; i >= 0; i--) {
				int temp = dp[i];
				dp[i] = cur.get(i) + Math.min(dp[i], prev);
				prev = temp;
			}
		}

		return dp[0];
	}
}
