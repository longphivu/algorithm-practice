package leetcode.dfs;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 21, 2016
 * Problem:		Q200_NumberOfIsland.java
 * Source:		https://leetcode.com/problems/number-of-islands/
 *
 * Description:	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Solution:	DFS
 * Complexity:	O(nm) only visit each cell 2 times
 * Notes:
 *				
 * Follow up:	(M) Surrounded Regions   (M) Walls and Gates   (H) Number of Islands II   (M) Number of Connected Components in an Undirected Graph  
 */
public class Q200_NumberOfIsland {
	public int numIslands(char[][] grid) {
        if (grid.length < 1) return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] mark = new int[n][m];
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //if this is island and haven't visited yet, increase count
                if (grid[i][j] == '1' && mark[i][j] == 0) {
                    cnt++;
                    dfs(i, j, grid, n, m, mark);
                }
            }
        }
        return cnt;
    }
    
    private static void dfs(int x, int y, char[][] grid, int n, int m, int[][] mark) {
        //outbound
        if (x >= n || x < 0) return;
        if (y >= m || y < 0) return;
        //already visit
        if (mark[x][y] == 1) return;
        //not land
        if (grid[x][y] == '0') return;
        
        //mark visited
        mark[x][y] = 1;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(j) != Math.abs(i))
                    dfs(x+i, y+j, grid, n, m, mark);
            }
        }
    }
}
