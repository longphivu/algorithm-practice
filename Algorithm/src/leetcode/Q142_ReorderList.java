package leetcode;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 6, 2016
 * Problem:		Q142_ReorderList.java
 * Source:		https://leetcode.com/problems/reorder-list/
 *
 * Description:	Given a singly linked list L: L0->L1->…->Ln-1->Ln,
				 reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->… 
				You must do this in-place without altering the nodes values.
				For example,
				 Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 * Solution:	separate into 2 lists, reverse second list, merge them together
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Partition List   (M) Linked List Cycle II   (M) Sort List  
 */
public class Q142_ReorderList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        //separate into 2 lists
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode second = slow.next;
        slow.next = null; //head become first list
        
        //reverse second list
        second = reverse(second);
        
        //merge first and second list;
        merge(head, second);
    }
    
    private void merge(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode temp1 = (head1 == null) ? null : head1.next;
            ListNode temp2 = (head2 == null) ? null : head2.next;
            
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
    }
    
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;
        
        ListNode pre = node;
        ListNode cur = node.next;
        pre.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
