package leetcode.backtrack;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 17, 2016
 * Problem:		Q052_NQueenII.java
 * Source:		https://leetcode.com/problems/n-queens-ii/
 *
 * Description:	Follow up for N-Queens problem.
				Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Solution:	Backtracking technique 
 * Complexity:	O(n!): T(n)= n*(T(n-1) + O(n))
 * Notes:
 *				
 * Follow up:	
 */
public class Q052_NQueenII {
	public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            board[0][i] = 1;
            total += solve(board, 1); //start at next row 1
            board[0][i] = 0;
        }    
        
        return total;
    }
    
    private int solve(int[][] board, int index) {
        if (index >= board.length) {
            return 1;//finish fill all the queens    
        }
        int total = 0;
        //else not finish yet, continue try filling the queens
        for (int j = 0; j < board.length; j++) {
            if (isValid(board, index, j)) {
                board[index][j] = 1;
                total += solve(board, index + 1);
                board[index][j] = 0;
            }
        }
        
        return total;
    }
    
    private boolean isValid(int[][] board, int x, int y) {
        //check column above
        for (int i = x-1; i >= 0; i--) {
            if (board[i][y] == 1) return false;
        }
        //check upper backward slash
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        //check upper forward slash
        for (int i = x-1, j = y+1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
		Q052_NQueenII nq = new Q052_NQueenII();
		System.out.println(nq.totalNQueens(20));
	}
}
