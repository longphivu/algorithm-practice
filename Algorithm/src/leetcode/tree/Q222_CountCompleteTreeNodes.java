package leetcode.tree;

import common.TreeNode;
import common.TreeUtility;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 8, 2016
 * Problem:		Q222_CountCompleteTreeNodes.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q222_CountCompleteTreeNodes {

	private static int rightMostDepth(TreeNode root) {  //the depth from root to the right most leave
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
    public static int countNodes(TreeNode root) {
        int depth = rightMostDepth(root);   //depth of the last full level
        int result = (1 << depth) - 1;  //num of nodes from root to the last full level
        TreeNode cur = root;
        int rootdepth = 1;
        while (cur != null) {
            int leftdepth = rightMostDepth(cur.left);
            if (leftdepth + rootdepth == depth) cur = cur.left; //the partially full level ends within the left subtree
            else {  //ends in the right subtree
                result += (1 << leftdepth - 1); //add the number of nodes in the partially full level within the left subtree
                cur = cur.right;    //continue to search for the end point of partially full level
            }
            rootdepth++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
		
		TreeNode root = TreeUtility.buildTree(arr);
		
		System.out.println(countNodes(root));
	}

}
