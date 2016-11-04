package common;

public class TreeUtility {

	public static TreeNode buildTree(int[] arr) {
		if (arr == null || arr.length == 0) 
			return null;
		
		TreeNode root = new TreeNode(arr[0]);
		
		buildTreeHelper(root, arr, 0);
		
		return root;
	}
	
	private static void buildTreeHelper(TreeNode node, int[] arr, int idx) {
		if (node == null) return;
		if (idx >= arr.length) return;
		
		int l = idx*2 + 1;
		int r = idx*2 + 2;
		
		if (l < arr.length && arr[l] != Integer.MAX_VALUE)
			node.left = new TreeNode(arr[l]);
		if (r < arr.length && arr[r] != Integer.MAX_VALUE)
			node.right = new TreeNode(arr[r]);
		
		buildTreeHelper(node.left, arr, l);
		buildTreeHelper(node.right, arr, r);
	}
}
