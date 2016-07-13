package leetcode;
/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
import universal.ListNode;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 13, 2016
 * Problem: 	Q2_AddTwoNumber.java
 * Source:		https://leetcode.com/problems/add-two-numbers/
 * 
 * Description:
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Solution:	dummy head, keep track of the carry using a variable
 * Complexity:	O(n)
 * Notes:		take caution of the cases: when one list longer than the other; when one list is null; when the last sum may have extra carry at the end 
 * 
 * Follow up:	(M) Multiply Strings,   (E) Add Binary,   (E) Sum of Two Integers  
 */
public class Q2_AddTwoNumber {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        int carry = 0;
        while(l1 != null || l2!= null || carry == 1){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            
            cur.next = new ListNode(sum);
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            cur = cur.next;
        }
        
        return head.next;
    }
}
