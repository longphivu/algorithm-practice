package leetcode.linkedlist;

import common.ListNode;

public class Q021_MergeTwoSortList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode headcopy = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				headcopy.next = l1;
				l1 = l1.next;
			} else if (l2.val <= l1.val) {
				headcopy.next = l2;
				l2 = l2.next;
			}
			headcopy = headcopy.next;
		}

		headcopy.next = (l1 == null ? l2 : l1);
		return head.next;
	}
}
