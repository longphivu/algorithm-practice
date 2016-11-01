package leetcode.dp;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 1, 2016
 * Problem:		Q64_MinimumPathSum.java
 * Source:		https://leetcode.com/problems/minimum-path-sum/
 *
 * Description:	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
				Note: You can only move either down or right at any point in time.
 *
 * Solution:	dynamic programming, travel each node, add the smaller node value from top or left
 * Complexity:	O(mn)
 * Notes:
 *				
 * Follow up:	(M) Unique Paths   (H) Dungeon Game  
 */
public class Q064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        
        if (m < 1) return 0;
        
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) 
			grid[i][0] += grid[i - 1][0];
        
        for (int j = 1; j < n; j++) 
			grid[0][j] += grid[0][j - 1];
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
		return grid[m - 1][n - 1];
    }
}
