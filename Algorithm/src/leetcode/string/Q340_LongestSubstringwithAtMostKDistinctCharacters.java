package leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 18, 2016
 * Problem:		Q340_LongestSubstringwithAtMostKDistinctCharacters.java
 * Source:		
 *
 * Description:	This is a problem asked by Google.
				Given a string, find the longest substring that contains only two unique characters. 
				For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb". 
 *
 * Solution:	Use a map to track encounter characters, count them up, when map size reach k, count them down, remove the one with count = 0
 * Complexity:	O(n)
 * Notes:		
 *				
 * Follow up:	?
 */
public class Q340_LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		String s = "abcbbbbcccdddccddccadacb";
		System.out.println(longestSubstring(s, 3));
	}
	
	public static String longestSubstring(String str, int k) {
		
		if (k <= 0) return "";
		
		int left = 0;
		int max_left = 0;
		int max_len = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else 
				map.put(c, 1);
			
			if (map.size() > k) {
				int len = i-1-left+1;
				if (len > max_len) {
					max_left = left;
					max_len = len;
				}
				
				while (map.size() > k) {
					char l = str.charAt(left);
					if (map.get(l) == 1)
						map.remove(l);
					else
						map.put(l, map.get(l) - 1);
					left++;
				}
			}
		}
		
		if (max_len == 0)	return str;
		
		return str.substring(max_left, max_left+max_len);
	}

}
