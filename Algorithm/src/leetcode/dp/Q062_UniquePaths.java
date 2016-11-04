package leetcode.dp;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 4, 2016
 * Problem:		Q062_UniquePaths.java
 * Source:		https://leetcode.com/problems/unique-paths/
 *
 * Description:	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
				The robot can only move either down or right at any point in time. 
				The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
				How many possible unique paths are there?
 *
 * Solution:	DP
 * Complexity:	O(mn)
 * Notes:
 *				
 * Follow up:	
 */
public class Q062_UniquePaths {
	public int uniquePaths(int m, int n) {
        int[][] df = new int[m][n];
        
        df[0][0] = 1;//at start we have 1 solution/way
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    continue; //skip starting position
                
                int up  = i > 0 ? df[j][i-1] : 0; //solution from above block
                int left = j > 0 ? df[j-1][i] : 0; //solution from left block
                //solution for current block is sum of top and left since
                //robot only able to move down or right
                df[j][i] = up + left;
            }
        }
        
        return df[m-1][n-1];
    }
}
