package hackerrank.tutorial;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 12, 2016
 * Problem:		Queues_ATaleTwoStacks.java
 * Source:		https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 *
 * Description:	In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types: 
				1.1 x: Enqueue element  into the end of the queue.
				2.2: Dequeue the element at the front of the queue.
				3.3: Print the element at the front of the queue.
 * Solution:	2 stacks, one to enqueue, one to dequeue, push elements from enqueue stack to dequeue stack on when it is empty
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Queues_ATaleTwoStacks {
	public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<E> {
    Stack<E> addStack;
    Stack<E> getStack;
    boolean isDequeue = false; //use to check if we are in dequeue state
    public MyQueue() {
        addStack = new Stack<E>();
        getStack = new Stack<E>();
    }
    
    public void enqueue(E e) {
        addStack.push(e);
    }
    
    public E dequeue() {
        if (getStack.isEmpty()) { //if not in dequeue, pour to get stack
            pour(addStack, getStack);
        }
        return getStack.pop();
    }
    
    public E peek() {
        if (getStack.isEmpty()) {
            pour(addStack, getStack);
        }
        return getStack.peek();
    }
    
    private void pour(Stack<E> from, Stack<E> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}