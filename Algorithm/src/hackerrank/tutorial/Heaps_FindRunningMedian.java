package hackerrank.tutorial;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 12, 2016
 * Problem:		Heaps_FindRunningMedian.java
 * Source:		https://www.hackerrank.com/challenges/ctci-find-the-running-median
 *
 * Description:	Given an input stream of  integers, you must perform the following task for each  integer:
				1.Add the  integer to a running list of integers.
				2.Find the median of the updated list (i.e., for the first element through the  element).
				3.Print the list's updated median on a new line. The printed value must be a double-precision number scaled to  decimal place (i.e.,  format).
 * Solution:	Use 2 heaps
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Heaps_FindRunningMedian {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int a_i=0; a_i < n; a_i++){
            int a = in.nextInt();
            
            maxHeap.add(a);
            //maintain size of 2 heaps, 
            //max heap must have number of elements equal or greater than min heap
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
            
            double median = 0;
            if (maxHeap.size() == minHeap.size())
                median = (maxHeap.peek()+minHeap.peek())/2.0;
            else
                median = maxHeap.peek();
            
            System.out.println(median);
        }
        in.close();
    }
}
