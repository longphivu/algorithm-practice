package leetcode.linkedlist;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 7, 2016
 * Problem:		Q082_RemoveDuplicatesFromSortedListII.java
 * Source:		https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Description:	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
				For example,
				 Given 1->2->3->3->4->4->5, return 1->2->5.
				 Given 1->1->1->2->3, return 2->3. 
 * Solution:	second loop to go through all duplicated nodes
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Merge k Sorted Lists   (M) Insertion Sort List   (M) Design Phone Directory  
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q082_RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (val == cur.next.next.val) {
                while (cur.next != null && val == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
