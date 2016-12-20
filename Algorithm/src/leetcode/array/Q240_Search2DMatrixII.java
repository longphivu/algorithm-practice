package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Dec 20, 2016
 * Problem:		Q240_Search2DMatrixII.java
 * Source:		https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Description:	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
			    Integers in each row are sorted in ascending from left to right.
			    Integers in each column are sorted in ascending from top to bottom.
				For example,
				Consider the following matrix:
				[
				  [1,   4,  7, 11, 15],
				  [2,   5,  8, 12, 19],
				  [3,   6,  9, 16, 22],
				  [10, 13, 14, 17, 24],
				  [18, 21, 23, 26, 30]
				]
				Given target = 5, return true.
				Given target = 20, return false.
 *
 * Solution:	start at top-right
 * 				if current position greater than target, target will not be in the current column 
 * 				if current position is less than the target, target will not be in the current row
 * Complexity:	O(m+n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q240_Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return false;
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        int row = 0; 
        int col = n; //start at top right
        while (row <= m && col >= 0) {
            if (matrix[row][col] == target) 
                return true;//target found
            
            if (matrix[row][col] < target)
                row++;
            else    //matrix[row][col] > target
                col--;
        }
        
        return false;
    }
}
