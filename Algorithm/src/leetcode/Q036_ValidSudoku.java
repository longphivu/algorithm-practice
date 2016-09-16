package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 16, 2016
 * Problem:		Q036_ValidSudoku.java
 * Source:		https://leetcode.com/problems/valid-sudoku/
 *
 * Description:	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
				The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
				Note:
				A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 
 * Solution:	
 * Complexity:	O(n^3)
 * Notes:
 *				
 * Follow up:	(H) Sudoku Solver  
 */
public class Q036_ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' 
                    && (!isBlockValid(board, i, j) || !isColumnValid(board, i, j) || !isRowValid(board, i, j))) {
                        return false;
                    }
            }
        }
        return true;
    }
    
    private boolean isBlockValid(char[][] board, int x, int y) {
        //get the start block coordinator       
        int cBlock = x - x%3; //eliminate bla bla
        int rBlock = y - y%3;
        for (int i = 0; i < 3; i++) {
            int x1 = cBlock+i;
            for (int j = 0; j < 3; j++) {
                int y1 = rBlock+j;
                if (x1 != x && y1 != y && board[x1][y1] == board[x][y])
                    return false;
            }
        }
        return true;
    }
    
    private boolean isColumnValid(char[][] board, int x, int y) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (i != x && board[i][y] == board[x][y])
                return false;
        }
        return true;
    }
    
    private boolean isRowValid(char[][] board, int x, int y) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (i != y && board[x][i] == board[x][y]) 
                return false;
        }
        return true;
    }
}
