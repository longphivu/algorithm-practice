package leetcode.tree;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 7, 2016
 * Problem:		Q110_BalanceBinaryTree.java
 * Source:		https://leetcode.com/problems/balanced-binary-tree/
 *
 * Description:	Given a binary tree, determine if it is height-balanced.
				For this problem, a height-balanced binary tree is defined as a binary tree 
				in which the depth of the two subtrees of every node never differ by more than 1. 
 *
 * Solution:	Find the depth, if the depth difference is more than 1, return -1 => imbalance
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q110_BalanceBinaryTree {
	
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        return depth(root) != -1;
    }
	
    public int depth(TreeNode node) {
        if (node == null) return 0;

        int dLeft = depth(node.left);
        if (dLeft == -1)
            return -1;
            
        int dRight = depth(node.right);
        if (dRight == -1 || Math.abs(dLeft-dRight) > 1)
            return -1;
            
        return 1 + Math.max(dLeft, dRight);
    }
}
