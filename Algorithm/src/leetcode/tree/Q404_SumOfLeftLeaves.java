package leetcode.tree;

import common.TreeNode;
/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 30, 2016
 * Problem:		Q404_SumOfLeftLeaves.java
 * Source:		https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Description:	Find the sum of all left leaves in a given binary tree.
 *
 * Solution:	DFS recursion, determine if a node has a left leaf
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Convert Sorted Array to Binary Search Tree  (M) Count Complete Tree Nodes  (M) House Robber III
 */
public class Q404_SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        //if left node is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
