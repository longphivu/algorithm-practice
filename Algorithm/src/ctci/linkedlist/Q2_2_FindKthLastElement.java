package ctci.linkedlist;

import common.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q2_2_FindKthLastElement.java
 * Source:		
 *
 * Description:	Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * Solution:	Recursion
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q2_2_FindKthLastElement {
	public static Node findKthLastNode(Node head, int k) {
		Node[] result = new Node[1];
		helper(head, k, result);
		return result[0];
	}
	
	private static int helper(Node node, int k, Node[] result) {
		if (node == null) return 0;
		int kth = 1 + helper(node.next, k, result);
		if (kth == k) {
			result[0] = node;
		}
		return kth;
	}
	
	public static void main(String[] arg) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		head.next = n1;
		n1.next = n2;
		System.out.println(findKthLastNode(head, 3).data);
	}
}
