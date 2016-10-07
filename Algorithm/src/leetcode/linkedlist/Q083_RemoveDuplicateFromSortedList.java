package leetcode.linkedlist;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 6, 2016
 * Problem:		Q083_RemoveDuplicateFromSortedList.java
 * Source:		https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Description:	Given a sorted linked list, delete all duplicates such that each element appear only once. 
				For example,
				 Given 1->1->2, return 1->2.
				 Given 1->1->2->3->3, return 1->2->3. 
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Merge k Sorted Lists   (M) Partition List   (M) Sort List  
 */
public class Q083_RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;//delete current node
            } else {
                pre = cur;
            } 
            cur = cur.next;
        }
        return head;
    }
}
