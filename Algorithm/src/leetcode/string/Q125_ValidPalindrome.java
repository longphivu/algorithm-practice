package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 4, 2016
 * Problem:		Q125_ValidPalindrome.java
 * Source:		https://leetcode.com/problems/valid-palindrome/
 *
 * Description:	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. 
				For example,
				"A man, a plan, a canal: Panama" is a palindrome.
				"race a car" is not a palindrome. 
 *
 * Solution:	Straing forward, skip all the non alphanumeric before compare
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Shortest Palindrome   (M) Basic Calculator II   (M) Encode and Decode Strings  
 */
public class Q125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		int length = s.length();
		int i = 0;
		int j = length - 1;
		while (i < j) {
			while (i < length && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (i < length && j >= 0 && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
