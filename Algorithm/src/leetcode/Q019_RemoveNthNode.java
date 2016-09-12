package leetcode;

import universal.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 14, 2016
 * Problem:		Q19_RemoveNthNode.java
 * Source:		https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Description:	Given a linked list, remove the nth node from the end of list and return its head.
				For example,
				   Given linked list: 1->2->3->4->5, and n = 2.
				   After removing the second node from the end, the linked list becomes 1->2->3->5.
				Note:
				 Given n will always be valid.
				 Try to do this in one pass. 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *					
 * Follow up:			
 */
public class Q019_RemoveNthNode {
	public Node removeNthFromEnd(Node head, int n) {
		return recursive(head, n) == n ? head.next : head;
		//return iterative(head, n);
	}
	
	private int recursive(Node node, int n){
		if(node == null)
			return 0;
		
		int k = 1 + recursive(node.next, n);
		
		if(k == n+1)
			node.next = node.next.next;
		
		return k;
	}
	
	private Node iterative(Node head, int n){
		Node fast = head;
		Node slow = head;
		
		while(n-- > 0 && fast != null)
			fast = fast.next;
		
		if(fast == null) 
			return head.next;
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return head;
	}
}
