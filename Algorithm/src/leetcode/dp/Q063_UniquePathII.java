package leetcode.dp;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 4, 2016
 * Problem:		Q063_UniquePathII.java
 * Source:		https://leetcode.com/problems/unique-paths-ii/
 *
 * Description:	Follow up for "Unique Paths":
				Now consider if some obstacles are added to the grids. How many unique paths would there be?
				An obstacle and empty space is marked as 1 and 0 respectively in the grid.
				For example,
				There is one obstacle in the middle of a 3x3 grid as illustrated below.
				[
				  [0,0,0],
				  [0,1,0],
				  [0,0,0]
				]
				The total number of unique paths is 2.
 *
 * Solution:	DP
 * Complexity:	O(mn)
 * Notes:
 *				
 * Follow up:	
 */
public class Q063_UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        
        int[][] df = new int[m][n];
        df[0][0] = 1;
        
        //initilize for first row
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) break;
            df[j][0] = 1;
        }
        
        //initilize for first column
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            df[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[j][i] == 1) continue;
                
                int top  = obstacleGrid[j][i-1] == 1 ? 0 : df[j][i-1];
                int left = obstacleGrid[j-1][i] == 1 ? 0 : df[j-1][i];
                df[j][i] = top + left;
            }
        }
        
        return df[m-1][n-1];
    }
}
