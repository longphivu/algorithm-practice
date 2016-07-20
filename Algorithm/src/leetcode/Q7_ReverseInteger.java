package leetcode;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 20, 2016
 * Problem: 	Q7_ReverseInteger.java
 * Source:		https://leetcode.com/problems/reverse-integer/
 *
 * Description:	Reverse digits of an integer.
 * 				Example1: x = 123, return 321
 * 				Example2: x = -123, return -321
 *
 * Solution:	Take out last digit, put it to the last of the current result
 * Complexity:	O(n)
 * Notes:		Be aware of overflow case
 *					
 * Follow up:	
 */
public class Q7_ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}

		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			res = 0;
		return (int) res;
	}
}
