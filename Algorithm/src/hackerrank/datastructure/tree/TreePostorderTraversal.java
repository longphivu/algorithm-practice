package hackerrank.datastructure.tree;

import java.util.Stack;

import common.TreeNode;

public class TreePostorderTraversal {
	void Postorder(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    
	    TreeNode cur = root;
	    do{
	        while(cur != null){
	            if(cur.right != null)    stack.push(cur.right);
	            stack.push(cur);
	            cur = cur.left;
	        }
	        
	        cur = stack.pop();
	        if(cur.right != null && !stack.empty() && cur.right == stack.peek()){
	            stack.pop();
	            stack.push(cur);
	            cur = cur.right;
	        }
	        else{
	            System.out.print(cur.data+" ");
	            cur = null;
	        }
	    }
	    while(!stack.isEmpty());
	}
}
