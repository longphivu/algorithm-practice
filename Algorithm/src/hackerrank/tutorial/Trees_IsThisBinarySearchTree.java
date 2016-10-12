package hackerrank.tutorial;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 12, 2016
 * Problem:		Trees_IsThisBinarySearchTree.java
 * Source:		https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 *
 * Description:	Given the root node of a binary tree, can you determine if it's also a binary search tree? 
 *
 * Solution:	Add two boundary limit for each node, check if the node valid within the boundaries.
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Trees_IsThisBinarySearchTree {
	boolean checkBST(TreeNode root) {
        int leftBound = Integer.MIN_VALUE;
        int rightBound = Integer.MAX_VALUE;
        return checkBSTHelper(root, leftBound, rightBound);
    }

    private boolean checkBSTHelper(TreeNode root, int leftBound, int rightBound) {
        if (root == null) 
            return true;
        
        if(root.data <= leftBound || root.data >= rightBound)
            return false;
        
        return checkBSTHelper(root.left, leftBound, root.data) 
            && checkBSTHelper(root.right, root.data, rightBound);
    }
}
