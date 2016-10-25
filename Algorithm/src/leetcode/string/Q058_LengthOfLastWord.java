package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 5, 2016
 * Problem:		Q058_LengthOfLastWord.java
 * Source:		https://leetcode.com/problems/length-of-last-word/
 *
 * Description:	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
				If the last word does not exist, return 0.
				Note: A word is defined as a character sequence consists of non-space characters only.
				For example, 
				 Given s = "Hello World",
				 return 5. 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(E) String to Integer (atoi)   (H) Scramble String   (M) Reverse Words in a String II  
 */
public class Q058_LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        int len = 0;
        boolean isCounting = false;
        char[] arr = s.toCharArray();
        for (int i = arr.length-1; i >= 0; i--) {
            char c = arr[i];
            if (c != ' ') {
                isCounting = true;
                len++;
            } else if (isCounting) {
                break;
            }
        }
		return len;
	}
}
