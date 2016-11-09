package ctci.tree;

import common.TreeNode;

public class IsBalanceBT {

	public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        return depth(root) != -1;
    }
    public static int depth(TreeNode node) {
        if (node == null) return 0;

        int dLeft = depth(node.left);
        if (dLeft == -1)
            return -1;
            
        int dRight = depth(node.right);
        if (dRight == -1 || Math.abs(dLeft-dRight) > 1)
            return -1;
            
        return 1 + Math.max(dLeft, dRight);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
