package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 17, 2016
 * Problem:		Q289_GameofLife.java
 * Source:		https://leetcode.com/problems/game-of-life/
 *
 * Description:	According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
				Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
				    1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
				    2.Any live cell with two or three live neighbors lives on to the next generation.
				    3.Any live cell with more than three live neighbors dies, as if by over-population..
				    4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
				Write a function to compute the next state (after one update) of the board given its current state.
 *
 * Solution:	
 * Complexity: O(8 x n^2)
 * Notes:
 *				
 * Follow up:	
			    1.Could you solve it in-place? Remember that the board needs to be updated at the same time: 
			      You cannot update some cells first and then use their updated values to update other cells.
			      Answer: Scan the board 2 times
			      			-First scan, update dead cell from 1 to -1, live cell form 0 to 2; treat -1 as 1, 2 as 0
			      			-Second scan, update any -1 to 0, 2 to 1
			    2.In this question, we represent the board using a 2D array. 
			      In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
			      How would you address these problems? 
			      Answer: use ArrayList, check the border if there is any cell will become live cell

 */
public class Q289_GameofLife {

	public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        int[][] mark = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                updateLiveCell(board, next, i, j, mark);
                updateDeadCell(board, next, i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            System.arraycopy(next[i], 0, board[i], 0, n);
        }
    }
    
    private int updateLiveCell(int[][] board, int[][] next, int x, int y, int[][] mark) {
        if (x >= board.length    || x < 0) return 0;
        if (y >= board[0].length || y < 0) return 0;
        
        if (mark[x][y] == 1) return 0; //already visited
        
        if (board[x][y] == 0) return 0; //dead cell
        
        mark[x][y] = 1; //mark as visit and proceed
        
        int count = 0;
        int[] xMoves = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] yMoves = {-1,  0,  1, -1, 1, -1, 0, 1};
        for (int i = 0; i < xMoves.length; i++) {
            count += countLive(board, x+xMoves[i], y+yMoves[i]);
        }
        
        //Rule1: Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        if (count < 2)
            next[x][y] = 0;
        
        //Rule2: Any live cell with two or three live neighbors lives on to the next generation.    
        if (count >= 2 && count <= 3) 
            next[x][y] = 1;
            
        //Rule3: Any live cell with more than three live neighbors dies, as if by over-population
        if (count > 3)
            next[x][y] = 0;
            
        return 1;
    }
    
    
    private int countLive(int[][] board, int x, int y) {
        if (x >= board.length    || x < 0) return 0;
        if (y >= board[0].length || y < 0) return 0;
        if (board[x][y] == 1)
            return 1;
        return 0;
    }
    
    private void updateDeadCell(int[][] board, int[][] next, int x, int y) {
        if (board[x][y] == 1) return; //live cell, we are updating dead cell
        
        int count = 0;
        
        int[] xMoves = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] yMoves = {-1,  0,  1, -1, 1, -1, 0, 1};
        for (int i = 0; i < xMoves.length; i++) {
            count += countLive(board, x + xMoves[i], y + yMoves[i]);
        }
        
        //Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        if (count == 3)
            next[x][y] = 1;
    }
    
	public static void main(String[] args) {
		Q289_GameofLife gol = new Q289_GameofLife();
		int[][] board = {{1,1},{1,0}};
		gol.gameOfLife(board);

	}

}
