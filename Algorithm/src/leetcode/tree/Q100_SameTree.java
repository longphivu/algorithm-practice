package leetcode.tree;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 4, 2016
 * Problem:		Q100_SameTree.java
 * Source:		https://leetcode.com/problems/same-tree/
 *
 * Description:	Given two binary trees, write a function to check if they are equal or not.
				Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 *
 * Solution:	
 * Complexity: 	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q100_SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        
        if (p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
