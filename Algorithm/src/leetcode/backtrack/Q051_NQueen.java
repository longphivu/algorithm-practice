package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 4, 2016
 * Problem:		NQueen.java
 * Source:		https://leetcode.com/problems/n-queens/
 *
 * Description:	The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 				Given an integer n, return all distinct solutions to the n-queens puzzle.

				Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
				both indicate a queen and an empty space respectively.
 *
 * Solution:	Backtracking technique
 * Complexity:	O(n!): T(n)= n*(T(n-1) + O(n))
 * Notes:
 *				
 * Follow up:	
 */
public class Q051_NQueen {

	public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        char[][] solution = new char[n][n];
        
        for (char[] row : solution)
        	Arrays.fill(row, '.');
        
        for (int i = 0; i < n; i++) {
            //set initial Q
            solution[0][i] = 'Q';
            //try to solve
            canSolve(solution, 1, results);
                
            //backtrack
            solution[0][i] = '.';
        }
        
        return results;
    }
    
    private boolean canSolve(char[][] matrix, int numOfQueens, List<List<String>> results) {
        int n = matrix.length;
        
        if (numOfQueens == n) {//finish at this point, solution is found
        	results.add(print(matrix));
        	return false;
        }
            
        for (int i = 0; i < n; i++) {
        	if (canPlace(matrix, numOfQueens, i)) {
        		matrix[numOfQueens][i] = 'Q';
        		if (canSolve(matrix, numOfQueens + 1, results)) {
        			results.add(print(matrix));
        		}
                //backtrack
                matrix[numOfQueens][i] = '.';
        	}
        }
        
        return false;
    }
    
    private boolean canPlace(char[][] matrix, int x, int y) {
        int n = matrix.length;
        
        //check column
        for (int i = x; i >= 0; i--) {
            if (matrix[i][y] == 'Q') 
                return false;
        }
        
        //no need to check row
        
        //check upper backslash diagonal '\'
        for (int i = x, j = y; i >= 0 && j >= 0; --i, --j) {
            if (matrix[i][j] == 'Q')
                return false;
        }
        
        //check upper forward slash diagonal '/'
        for (int i = x, j = y; i >= 0 && j < n; --i, ++j) {
            if (matrix[i][j] == 'Q')
                return false;
        }
        
        return true;
    }
    
    public List<String> print(char[][] solution) {
        List<String> results = new ArrayList<>();
        
        for (char[] row : solution) {
            results.add(String.valueOf(row));
        }
        
        return results;
    }
	
	public static void main(String[] args) {
		Q051_NQueen nq = new Q051_NQueen();
		System.out.println(nq.solveNQueens(5));
	}

}
