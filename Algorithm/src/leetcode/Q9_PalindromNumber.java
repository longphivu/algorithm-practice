package leetcode;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 20, 2016
 * Problem: 	Q9_PalindromNumber.java
 * Source:		https://leetcode.com/problems/palindrome-number/
 *
 * Description:	Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Solution:	Take out the last digit until meet the middle then compare result and input
 * Complexity:	O(n)
 * Notes:		Could negative integers be palindromes? (ie, -1)
 *					
 * Follow up:	(M) Integer to Roman   (M) Pow(x, n)   (M) Strobogrammatic Number II  
 */
public class Q9_PalindromNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;

		int y = 0;
		int d = 1;
		while ( d <= x) {
			y = y * 10 + x % 10;
			x /= 10;
			d *= 10;
		}

		if (y == x || y / 10 == x)
			return true;
		else
			return false;
	}
}
