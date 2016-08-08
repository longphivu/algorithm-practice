package leetcode;

import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 8, 2016
 * Problem:		Q120_Triangle.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
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
