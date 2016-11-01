package leetcode.linkedlist;

import common.ListNode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q024_SwapNodeInPair.java
 * Source:		https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * Description:	Given a linked list, swap every two adjacent nodes and return its head.
				For example,
				Given 1->2->3->4, you should return the list as 2->1->4->3.
				Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q024_SwapNodeInPair {
	public ListNode swapPairs(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        
        boolean isHead = true;
        while(currNode != null && currNode.next != null){
            //swap 2 nodes
            ListNode nextNode = currNode.next;
            currNode.next = nextNode.next;
            nextNode.next = currNode;
            
            //first 2 node, set head; else, set new next after swap
            if(isHead){
                head = nextNode;
                isHead = false;
            }else{
                prevNode.next = nextNode;
            }
            
            prevNode = currNode;
            currNode = currNode.next;
            
        }
        return head;
    }
}
