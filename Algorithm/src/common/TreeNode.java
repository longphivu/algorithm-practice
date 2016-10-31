package common;

public class TreeNode {
	public int data;
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	@Override
	public String toString(){
		return String.valueOf(val);
	}
}
