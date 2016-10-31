package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 31, 2016
 * Problem:		Q257_BinaryTreePaths.java
 * Source:		https://leetcode.com/problems/binary-tree-paths/
 *
 * Description:	Given a binary tree, return all root-to-leaf paths. 
 *				For example, given the following binary tree: 
				   1
				 /   \
				2     3
				 \
				  5
				All root-to-leaf paths are: 
				["1->2->5", "1->3"]
 * Solution:	DFS, use StringBuilder to store path, reset it after travel
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Binary Search Tree Iterator   (M) Inorder Successor in BST   (M) House Robber III  
 */
public class Q257_BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        
        dfs(root, sb, paths);
        
        return paths;
    }
    
    private void dfs(TreeNode node, StringBuilder sb, List<String> paths) {
        if (node == null) 
            return;
            
        sb.append(node.val).append("->");
        
        if (node.left == null && node.right == null) {
            sb.setLength(sb.length()-2);//remove last arrow
            paths.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        
        dfs(node.left, sb, paths);
        sb.setLength(len); //reset
        
        dfs(node.right, sb, paths);
        sb.setLength(len); //reset
    }
}
