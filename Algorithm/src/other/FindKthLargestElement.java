package other;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargestElement {

	public static void main(String[] args) {
		int[] arr = {2,3,1,5,4,6};
		int k = 3;
		System.out.println(findKthLargest(arr, k));
		
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int minSize = k-1;
		
		for (int i = 0; i < nums.length; i++) {
			if (i < k-1) { //first k-1 elements
				minHeap.offer(nums[i]);
			} else {
				minHeap.offer(nums[i]);
				maxHeap.offer(minHeap.poll());
			}
		}
		
		return maxHeap.peek();
	}
}
