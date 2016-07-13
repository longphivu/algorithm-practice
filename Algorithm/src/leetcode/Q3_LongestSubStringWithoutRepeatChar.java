package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 13, 2016
 * Problem: 	Longest Substring Without Repeating Characters
 * Source:		https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Description:	
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Solution:	use extra storage to store the location of characters, if meet again and its previous location is between current start index
 * 				and current index then start a new string/start index, and calculate the max
 * Complexity:	O(n) Time, O(n) Space
 * Notes:		make sure to check the charset or we can use Java Hash Map implement
 *					
 * Follow up:	(H) Longest Substring with At Most Two Distinct Characters  
 */
public class Q3_LongestSubStringWithoutRepeatChar {


	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring2("a"));

	}
	public static int lengthOfLongestSubstring(String str) {
        int s = 0;
        int max = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(charMap.containsKey(c))
                s = Math.max(charMap.get(c)+1,s);
                
            charMap.put(c, i);
            
            if(i-s+1 > max)
                max = i-s+1;
        }
        
        return max;
    }
	 public static int lengthOfLongestSubstring2(String s) {
	        int max = 0;
	        int start = 0;
	        
	        int[] lastSeen = new int[256];
	        for(int i = 0; i<256; i++){
	            lastSeen[i] = -1;
	        }
	        
	        for(int i = 0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(lastSeen[c] != -1){
	                start = Math.max(lastSeen[c]+1, start);
	            }
	            lastSeen[c] = i;
	            max = Math.max(i-start+1, max);
	        }
	        
	        return max;
	    }
}
