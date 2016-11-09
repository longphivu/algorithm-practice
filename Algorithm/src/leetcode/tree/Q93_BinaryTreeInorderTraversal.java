package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 9, 2016
 * Problem:		Q93_BinaryTreeInorderTraversal.java
 * Source:		https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Description:	Given a binary tree, return the inorder traversal of its nodes' values
 *
 * Solution:	Use stack, go all the left and push to stack, then pop and print value, 
 * 				then go 1 step to the right, repeat
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q93_BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) return list;
    
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            //go to the most left
            if (root != null) {
                stack.push(root);
                root = root.left; 
            } else { //finish going all the way to the left
                //get from the stack, and print result
                root = stack.pop();
                list.add(root.val);
                //go to the right, then repeat the loop
                root = root.right;
            }
        }
        
        return list;
    }
}
