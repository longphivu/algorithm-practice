package leetcode.tree;

import common.TreeNode;
import common.TreeUtility;

public class Q437_PathSumIII {

	public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        int cnt = pathSumHelper(root, sum, 0);
        
        return cnt + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private static int pathSumHelper(TreeNode node, int target, int sum) {
        if (node == null)  return 0;
        
        sum += node.val;
        
        int cnt = 0;
        if (sum == target) 
            cnt++;
        return cnt + pathSumHelper(node.left, target, sum) + pathSumHelper(node.right, target, sum);
    }
	
	public static void main(String[] args) {
		int[] arr = {10,5,-3,3,2,Integer.MAX_VALUE,11,3,-2,Integer.MAX_VALUE,1};
		TreeNode root = TreeUtility.buildTree(arr);
		
		System.out.println(pathSum(root, 8));
	}
	
	

}
