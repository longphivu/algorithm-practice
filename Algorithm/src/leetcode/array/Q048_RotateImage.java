package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q048_RotateImage.java
 * Source:		https://leetcode.com/problems/rotate-image/
 *
 * Description:	You are given an n x n 2D matrix representing an image.
				Rotate the image by 90 degrees (clockwise).
				Follow up:
				Could you do this in-place?
 *
 * Solution:	
 * Complexity:	O(n^2)
 * Notes:
 *				
 * Follow up:	
 */
public class Q048_RotateImage {
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        int layers = n / 2;
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                
                //save top
                int temp = matrix[first][i];
                
                //left -> top
                matrix[first][i]            = matrix[last-offset][first];
                
                //bottom -> left
                matrix[last-offset][first]  = matrix[last][last-offset];
                
                //right -> bottom
                matrix[last][last-offset]   = matrix[i][last];
                
                //top-left -> top-right
                matrix[i][last]             = temp;
            }
        }
    }
}
