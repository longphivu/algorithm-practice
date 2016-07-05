package JavaRevisited;

import universal.Node;

public class Q02_CheckLinkListLoop {
	public static boolean hasLoop(Node head) {
		
		if(head.next == null){
			return false;
		}
		
		Node fast = head;
		Node slow = head.next;
		while(fast != null && fast.next != null){
			if(fast == slow) return true;
			if(fast == head) return false;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return false;
	}
}
