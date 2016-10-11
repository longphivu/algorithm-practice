package hackerrank.tutorial;

import common.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 11, 2016
 * Problem:		LinkedLists_DetectCycle.java
 * Source:		https://www.hackerrank.com/challenges/ctci-linked-list-cycle
 *
 * Description:	A linked list is said to contain a cycle if any node is visited more than once while traversing the list. 
				Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named  that points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle in the list. If there is a cycle, return true; otherwise, return false.
 * Solution:	Linked list race technique, fast and slow
 * Complexity:	O(n)
 * Notes:		
 *				
 * Follow up:	
 */
public class LinkedLists_DetectCycle {
	boolean hasCycle(Node head) {
	    Node fast = head;
	    Node slow = head;
	    
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	        if (fast == slow) return true;
	    }
	    
	    return false;
	}
}
