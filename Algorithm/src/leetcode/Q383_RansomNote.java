package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 14, 2016
 * Problem:		Q383_RansomNote.java
 * Source:		https://leetcode.com/problems/ransom-note/
 *
 * Description:	Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * 				write a function that will return true if the ransom  note can be constructed from the magazines ; 
 * 				otherwise, it will return false.  
				Each letter in the magazine string can only be used once in your ransom note. 
				Note:
					You may assume that both strings contain only lowercase letters. 
				canConstruct("a", "b") -> false
				canConstruct("aa", "ab") -> false
				canConstruct("aa", "aab") -> true
 *
 * Solution:	Count frequency, similar to word anagram
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(H) Regular Expression Matching   (H) Longest Substring with At Most Two Distinct Characters   (H) Integer to English Words  
 */
public class Q383_RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (ransomNote.length() > magazine.length()) return false;
        
        int[] count = new int[256];
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (int i = 0; i < ran.length; i++)    count[ran[i]]++;
        for (int i = 0; i < mag.length; i++)    count[mag[i]]--;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) return false;        
        }
        
        return true;
    }
}
