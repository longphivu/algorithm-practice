package leetcode;

import java.util.Stack;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 26, 2016
 * Problem:		Q084_LargestRectangleHistogram.java
 * Source:		https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Description:	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * 				find the area of largest rectangle in the histogram. 
 *
 * Solution:	use stack to store the height, calculate max each time we reach lower height
 * Complexity:	O(n)
 * Notes:		can increase performance by using integer array stack 
 * Follow up:	(H) Maximal Rectangle  
 */
public class Q084_LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
}
