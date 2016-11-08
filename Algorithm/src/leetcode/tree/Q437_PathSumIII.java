package leetcode.tree;

import common.TreeNode;
import common.TreeUtility;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 8, 2016
 * Problem:		Q437_PathSumIII.java
 * Source:		https://leetcode.com/problems/path-sum-iii/
 *
 * Description:	You are given a binary tree in which each node contains an integer value.
				Find the number of paths that sum to a given value.
				The path does not need to start or end at the root or a leaf, but it must go downwards 
				(traveling only from parent nodes to child nodes).
				The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000. 
				root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
				      10
				     /  \
				    5   -3
				   / \    \
				  3   2   11
				 / \   \
				3  -2   1
				Return 3. The paths that sum to 8 are:
				1.  5 -> 3
				2.  5 -> 2 -> 1
				3. -3 -> 11
 *
 * Solution:	Count the sum from root, then do the same for its left and right node
 * Complexity:	O(n^2)
 * Notes:
 *				
 * Follow up:	
 */
public class Q437_PathSumIII {

	public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        int cnt = pathSumHelper(root, sum, 0);
        
        return cnt + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private static int pathSumHelper(TreeNode node, int target, int sum) {
        if (node == null)  return 0;
        
        sum += node.val;
        
        int cnt = 0;
        if (sum == target) 
            cnt = 1;
        return cnt + pathSumHelper(node.left, target, sum) + pathSumHelper(node.right, target, sum);
    }
	
	public static void main(String[] args) {
		int[] arr = {10,5,-3,3,2,Integer.MAX_VALUE,11,3,-2,Integer.MAX_VALUE,1};
		TreeNode root = TreeUtility.buildTree(arr);
		
		System.out.println(pathSum(root, 8));
	}
	
	

}
