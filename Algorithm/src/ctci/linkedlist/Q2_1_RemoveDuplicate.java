package ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

import common.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q2_1RemoveDuplicate.java
 * Source:		
 *
 * Description:	Write code to remove duplicates from an unsorted linked list.
 *
 * Solution:	Use Set
 * Complexity:
 * Notes:
 *				
 * Follow up:	How would you solve this problem if a temporary buffer is not allowed?
 */
public class Q2_1_RemoveDuplicate {
	public Node removeDuplicate(Node head) {
		if (head == null)
			return head;
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.data);
		
		Node prev = head;
		Node next = head.next;
		while (next != null) {
			if (set.contains(next.data)) {
				prev.next = next.next;
			} else {
				set.add(next.data);
				prev = next;
			}
			next = next.next;
		}
		
		return head;
	}
	
	public void removeDuplicateNoBuffer(Node head) {
		if (head == null) return;
		
		Node curr = head;
		while (curr != null) {
			Node prev = curr;
			Node next = curr.next;
			while (next != null) {
				if (curr.data == next.data) {
					prev.next = next.next; //move node
				} else {
					prev = next;
				}
				next = next.next;
			}
			curr = curr.next;
		}
	}
}
