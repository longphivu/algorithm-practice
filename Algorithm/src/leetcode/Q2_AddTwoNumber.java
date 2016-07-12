package leetcode;
/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
import universal.ListNode;

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
