package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 9, 2016
 * Problem:		Q145_BinaryTreePostorderTraversal.java
 * Source:		https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Description:	Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Solution:	Use stack, and 1 variable to store previous visited node, go all the way to the left and push to stack,
 * 				then peek and check if right node is null or already visited or not. If not move one step to the right
 * 				and repeat, otherwise print node value 
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q145_BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) { //go all the way to the left
                stack.push(root);
                root = root.left; 
            } else {
                root = stack.peek();
                if (root.right != null && pre != root.right) {
                    root = root.right;
                    pre = root;
                } else { //root.right is null or already visited
                    list.add(root.val);
                    stack.pop();
                    pre = root;
                    root = null;
                }
            }
        }
        
        
        return list;
    }
}
