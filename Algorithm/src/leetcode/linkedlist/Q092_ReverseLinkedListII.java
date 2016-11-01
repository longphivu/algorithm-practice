package leetcode.linkedlist;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q092_ReverseLinkedListII.java
 * Source:		https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Description:	Reverse a linked list from position m to n. Do it in-place and in one-pass.
				For example:
				Given 1->2->3->4->5->NULL, m = 2 and n = 4,
				return 1->4->3->2->5->NULL.
				
				Note:
				Given m, n satisfy the following condition:
				1 <= m <= n <= length of list. 
 *
 * Solution:	Same as reverse linked list
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q092_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        
        int position = 1;
        ListNode reverseHead = head; //reverseHead will be the head of the reverse list
        ListNode prev = new ListNode(0); // store the previous node of the reverse node
        prev.next = reverseHead;
        
        while (reverseHead != null) {
            if (position == m) { //start reverse
                ListNode next = reverseHead.next;
                ListNode lastNode = reverseHead;
                while (position < n) {
                    ListNode temp = next.next;
                    next.next = reverseHead;
                    reverseHead = next;
                    next = temp;
                    position++;
                }
                lastNode.next = next;
                prev.next = reverseHead;
                break;
            }
            reverseHead = reverseHead.next;
            prev = prev.next;
            position++;
        }
        
        if (m == 1)
            return reverseHead;
        else 
            return head;
    }
}
