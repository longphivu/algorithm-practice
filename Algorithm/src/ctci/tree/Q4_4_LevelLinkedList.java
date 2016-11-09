package ctci.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class Q4_4_LevelLinkedList {
	public static List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		List<LinkedList<TreeNode>> results = new ArrayList<>();
		
		if (root == null) 
			return results;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<TreeNode> list = new LinkedList<>();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				list.add(0, node);
				
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			Collections.reverse(list);
			results.add(list);
		}
		
		return results;
	}
}
