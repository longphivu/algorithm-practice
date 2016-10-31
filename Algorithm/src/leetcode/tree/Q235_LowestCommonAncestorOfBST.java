package leetcode.tree;

import common.TreeNode;
/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 30, 2016
 * Problem:		Q235_LowestCommonAncestorOfBST.java
 * Source:		https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Description:	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
				According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
				two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).” 
 * Solution:	DFS
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Closest Binary Search Tree Value II  (M) Inorder Successor in BST  (E) Sum of Left Leaves
 */
public class Q235_LowestCommonAncestorOfBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) 
            return root;
        
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        
        if (min <= root.val && root.val <= max) {
            return root;
        }
        
        if (root.val >= max) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
