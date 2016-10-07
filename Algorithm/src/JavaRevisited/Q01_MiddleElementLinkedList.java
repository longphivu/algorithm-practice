package JavaRevisited;

import common.Node;

public class Q01_MiddleElementLinkedList {
	public static Node getMiddle(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String... art){
		Node n1 = new Node(1);Node n2 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
	//	n1.next.next.next.next = new Node(5);
		
		System.out.println(getMiddle(n1).data);
		System.out.println(n1.equals(n2));
		System.out.println(n1==n2);
	}
}
