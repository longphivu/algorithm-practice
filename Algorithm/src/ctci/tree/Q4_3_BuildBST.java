package ctci.tree;

import common.TreeNode;

public class Q4_3_BuildBST {
	
	public static TreeNode buildBST(int[] arr, int from, int to) {
		if (to < from || to < 0 || from >= arr.length) 
			return null;
		
		int position = (to + from) / 2;
		TreeNode root = new TreeNode(arr[position]);
		
		root.left = buildBST(arr, from, position-1);
		root.right = buildBST(arr, position+1, to);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		TreeNode root = buildBST(arr, 0, arr.length-1);
		System.out.println(root);
	}
}
