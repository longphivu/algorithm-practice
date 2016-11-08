package leetcode.tree;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 8, 2016
 * Problem:		Q124_BinaryTreeMaximumPathSum.java
 * Source:		https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Description:	 Given a binary tree, find the maximum path sum.
				For this problem, a path is defined as any sequence of nodes from some starting node to any node in 
				the tree along the parent-child connections. The path must contain at least one node and does not 
				need to go through the root.
				For example:
				Given the below binary tree,
				       1
				      / \
				     2   3
				Return 6. 
 *
 * Solution:	Use global variable to store/check max at each node, 
 * 				each node should store the maximum sum from itself to its leaves
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q124_BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		Result res = new Result();
		res.val = Integer.MIN_VALUE;

		helper(root, res);
		return res.val;
	}

	private int helper(TreeNode root, Result res) {
		if (root == null)
			return 0;
		int left = Math.max(helper(root.left, res), 0);
		int right = Math.max(helper(root.right, res), 0);

		res.val = Math.max(res.val, root.val + left + right);

		return root.val + Math.max(left, right);
	}
}

class Result {
	int val;
}