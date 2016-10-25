package leetcode.array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 3, 2016
 * Problem:		Q295_FindMedianFromDataStream.java
 * Source:		https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Description:	Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
				Examples: 
				[2,3,4] , the median is 3
				[2,3], the median is (2 + 3) / 2 = 2.5 
				Design a data structure that supports the following two operations: 
				•void addNum(int num) - Add a integer number from the data stream to the data structure.
				•double findMedian() - Return the median of all elements so far.
				For example:
				add(1)
				add(2)
				findMedian() -> 1.5
				add(3) 
				findMedian() -> 2
 * Solution:	Use 2 Heaps
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q295_FindMedianFromDataStream {
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();//store upper half elements
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());//store lower half elements
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {//maintains the heaps size,
        									  //max heap's size must greater or equals min heap's size
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
    	//find median by get value from top of 2 heap, maxHeap's size always greater than minHeap
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();