package leetcode;

import universal.Node;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 14, 2016
 * Problem: 	Q19_RemoveNthNode.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	O(n)
 * Complexity:
 * Notes:
 *					
 * Follow up:			
 */
public class Q19_RemoveNthNode {
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
