package leetcode.tree;

import java.util.Stack;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 8, 2016
 * Problem:		Q230_KthSmallestElementBST.java
 * Source:		https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Description:	Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
				Note:
				You may assume k is always valid, 1 <= k <= BST's total elements.
 *
 * Solution:	Iterative InOrder Traversal 
 * Complexity:	O(k)
 * Notes:
 *				
 * Follow up:	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * 				How would you optimize the kthSmallest routine?
 */
public class Q230_KthSmallestElementBST {
	
	public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        int order = 0;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                
                order++;
                if (order == k)
                    return root.val;
                
                root = root.right;
            }
        }
        
        return -1;
    }
	
	public static int kthSmallestRecursive(TreeNode root, int k) {
        Order order = new Order();
        return helper(root, k, order);
    }
    
    private static int helper(TreeNode root, int k, Order order) {
        if (root == null) return -1;
        int result = helper(root.left, k, order);
        
        if (order.val == k)
            return result;
        else if (++order.val == k)
            return root.val;
        
        return helper(root.right, k, order);
    }
}

class Order {
    int val = 0;
}
