package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 20, 2016
 * Problem:		Q239_SlidingWindowMaximum.java
 * Source:		https://leetcode.com/problems/sliding-window-maximum/
 *
 * Description:	Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
				For example,
				 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
				Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Solution:	Use double end queue, deque/dequeue
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Longest Substring with At Most Two Distinct Characters   (H) Paint House II  
 */
public class Q239_SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        if (k < 1) return new int[0];
        
        int[] results = new int[n-k+1];
        
        //create dequeue, we keep track of the index of element 
        Deque<Integer> deque = new LinkedList<Integer>();
        
        //build the deque for first k elements
        int i = 0;
        while (i < k) {
            //remove useless elements, element that is less than current element
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            //push to the back
            deque.offerLast(i);
            i++;
        }
        
        //for the rest of the array
        int idx = 0;
        while (i < n) {
            //first element of dequeue will be the largest in current sliding window
            results[idx++] = nums[deque.peekFirst()];
            //remove element if out side of the sliding window
            while (!deque.isEmpty() && deque.peekFirst() < i+1-k)
                deque.pollFirst();
            //build up, do the same    
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
            i++;
        }
        if (!deque.isEmpty())
            results[idx] = nums[deque.peekFirst()];
        
        return results;
    }
}
