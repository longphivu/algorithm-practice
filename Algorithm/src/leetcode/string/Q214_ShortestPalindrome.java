package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 5, 2016
 * Problem:		Q214_ShortestPalindrome.java
 * Source:		https://leetcode.com/problems/shortest-palindrome/
 *
 * Description:	Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation. 
				For example: 
				Given "aacecaaa", return "aaacecaaa".
				Given "abcd", return "dcbabcd".
 *
 * Solution:	Find the palindrome with start by the left most character, the rest will be add to result in reverse order
 * Complexity:	O(n^2)
 * Notes:		KMP can be used to solve this https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation
 *				
 * Follow up:	(H) Palindrome Pairs  
 */
public class Q214_ShortestPalindrome {

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
	}

	public static String shortestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;

		StringBuilder sb = new StringBuilder();
		int left = 0;
		int right = s.length()-1;
		// find right index of the left most palindrome (start at index 0)
		int mid = s.length() / 2;
		for (int i = mid; i >= 0; i--) {
			int len = 1;
			len = Math.max(getLeftMostPalindrome(s, i, i), getLeftMostPalindrome(s, i - 1, i));
			left = i - len/2;
			if (left == 0) {
				right = len - 1;
				break;
			}

		}
		// chars from current right to the rest of the string is what we need to
		// add, in reverse order
		for (int i = s.length() - 1; i > right; i--) {
			sb.append(s.charAt(i));
		}

		return sb.append(s).toString();
	}
	
	/**
	 * Return the length of the palindrome
	 * @param s
	 * @param mid1
	 * @param mid2
	 * @return
	 */
	public static int getLeftMostPalindrome(String s, int mid1, int mid2) {
		if (mid1 < 0 || mid1 >= s.length()) return 0;
		if (mid2 < 0 || mid2 >= s.length()) return 0;
			
        int i = mid1;
        int j = mid2;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j))
                break;
            i--;
            j++;
        }
        return j-i-1;
    }
}
