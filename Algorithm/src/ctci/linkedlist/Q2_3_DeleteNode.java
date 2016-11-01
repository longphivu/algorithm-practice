package ctci.linkedlist;

import common.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q2_2_DeleteNode.java
 * Source:		
 *
 * Description:	Implement an algorithm to delete a node in the middle of a singly linked list, given
				only access to that node.
 *
 * Solution:	copy value to delete node
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q2_3_DeleteNode {
	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null)
			return false;

		n.data = n.next.data;
		n.next = n.next.next;
		
		return true;
	}
}
