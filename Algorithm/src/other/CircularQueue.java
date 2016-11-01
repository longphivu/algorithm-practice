package other;

public class CircularQueue<E> {
	private E[] queue;
	private int maxSize; // Maximum Size of Circular Queue

	private int rear; // elements will be added/queued at rear.
	private int front; // elements will be removed/dequeued from front
	private int size; // size of elements currently in Priority Queue

	/**
	 * Constructor
	 */
	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = (E[]) new Object[this.maxSize];
		size = 0; // Initially size of elements in Circular Queue are 0.
		front = 0;
		rear = 0;
	}


	public void enqueue(E item) throws Exception {
		if (isFull()) {
			throw new Exception("Circular Queue is full");
		} else {
			queue[rear] = item;
			rear = (rear + 1) % queue.length;
			size++; // increase size of elements in Circular queue
		}
	}


	public E dequeue() throws Exception {
		E deQueuedElement;
		if (isEmpty()) {
			throw new Exception("Circular Queue is empty");
		} else {
			deQueuedElement = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			size--; // Reduce size of elements from Circular queue
		}
		return deQueuedElement;
	}

	/**
	 * Return true if Circular Queue is full.
	 */
	public boolean isFull() {
		return (size == queue.length);
	}

	/**
	 * Return true if Circular Queue is empty.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	public static void main(String... arg) throws Exception {
		CircularQueue<Integer> queue = new CircularQueue<>(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		queue.enqueue(6);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
