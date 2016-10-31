package leetcode.tree;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 31, 2016
 * Problem:		Q226_InvertBinaryTree.java
 * Source:		https://leetcode.com/problems/invert-binary-tree/
 *
 * Description:	Invert a binary tree. 
 *				     4
				   /   \
				  2     7
				 / \   / \
				1   3 6   9
				
				to
				
				     4
				   /   \
				  7     2
				 / \   / \
				9   6 3   1
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q226_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if (root == null) 
            return root;
            
        TreeNode t = root.right;
        root.right = root.left;
        root.left = t;
        
        invertTree(root.right);
        invertTree(root.left);
        
        return root;
    }
}
