package hackerrank.tutorial;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 21, 2016
 * Problem:		DFS_ConnectedCellinGrid.java
 * Source:		https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 *
 * Description:	Given an  matrix, find and print the number of cells in the largest region in the matrix. 
 * 				Note that there may be more than one region in the matrix.
 * Solution:	DFS, additional space to mark visited cells
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class DFS_ConnectedCellinGrid {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		in.close();

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int size = dfs(i, j, n, m, grid);
				max = Math.max(max, size);
			}
		}

		System.out.println(max);
	}

	private static int dfs(int i, int j, int n, int m, int[][] grid) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return 0;
		if (grid[i][j] == 0)
			return 0;

		grid[i][j] = 0;

		// find size of the rest of the island
		int size = 1;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				size += dfs(x + i, y + j, n, m, grid);
			}
		}
		return size;
	}
}
