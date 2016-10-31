package leetcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.TreeNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 31, 2016
 * Problem:		Q236_LowestCommonAncestorOfBT.java
 * Source:		https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Description:	Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. 
				According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
				two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).” 
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	(M) Binary Tree Upside Down   (M) Count Univalue Subtrees   (M) Largest BST Subtree  
 */
public class Q236_LowestCommonAncestorOfBT {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<TreeNode>();
        List<TreeNode> qPath = new ArrayList<TreeNode>();
        
        dfs(root, p, pPath);
        dfs(root, q, qPath);
        
        TreeNode common = root;
        Iterator pIterator = pPath.iterator();
        Iterator qIterator = qPath.iterator();
        while (pIterator.hasNext() && qIterator.hasNext()) {
            TreeNode pNode = (TreeNode) pIterator.next();
            TreeNode qNode = (TreeNode) qIterator.next();
            if (pNode == qNode) {
                common = pNode;
            } else {
                break;
            }
        }
        
        return common;
    }
    
    private static boolean dfs(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null || node == null) 
            return false;
        
        list.add(root);
        
        if (root == node) 
            return true;
        
        if (dfs(root.left, node, list)) {
            return true;
        } else if (dfs(root.right, node, list)) {
            return true;
        } else {
            list.remove(list.size() - 1);
            return false;
        }
    }
    
    public static void main(String[] arg) {
		TreeNode root = new TreeNode(0);
		TreeNode r = new TreeNode(1);
		TreeNode l = new TreeNode(2);
		TreeNode r1 = new TreeNode(3);
		TreeNode l1 = new TreeNode(4);
		
		root.left = l;
		root.right = r;
		r.left = l1;
		r.right = r1;
		
		System.out.println(lowestCommonAncestor(root, r1, l1));
	}
}
