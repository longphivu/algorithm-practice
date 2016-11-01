package ctci.linkedlist;

import common.Node;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q2_4_PartitionList.java
 * Source:		
 *
 * Description:	Write code to partition a linked list around a value x, such that all nodes less than x
				come before alt nodes greater than or equal to x
 *
 * Solution:	create 2 list, combine at the end
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	partition in array
 */
public class Q2_4_PartitionList {
	public static Node partition(Node head, int x) {
		Node dummy1 = new Node(0);
		Node dummy2 = new Node(0);
		Node greater = new Node(0);
		Node smaller = new Node(0);
		
		dummy1.next = greater;
		dummy2.next = smaller;
		
		Node curr = head;
		while (curr != null) {
			if (curr.data >= x) {
				greater.next = curr;
				greater = greater.next;
			} else {
				smaller.next = curr;
				smaller = smaller.next;
			}
			curr = curr.next;
		}
		
		//combine
		greater.next = dummy2.next.next;
		//set end of the list
		smaller.next = null;
		
		return dummy1.next.next;
	}
	
	public static void main(String[] art) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		head.next = n1;
		n1.next = n2;

		Node ret = partition(head, 2);
		
		while (ret != null) {
			System.out.print(ret.data+ " ");
			ret = ret.next;
		}
	}
}
