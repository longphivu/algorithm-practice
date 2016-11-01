package leetcode.linkedlist;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q206_ReverseLinkedList.java
 * Source:		https://leetcode.com/problems/reverse-linked-list/
 *
 * Description:	Reverse a singly linked list.
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Q206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        
        return head;
    }
	
	public static ListNode recursiveSol(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = recursiveSol(next);
		next.next = head;
		head.next = null;
		return newHead;
	}
}
