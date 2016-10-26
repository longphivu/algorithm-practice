package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 26, 2016
 * Problem:		HaystackAndNeedle.java
 * Source:		
 *
 * Description:	Have 2 strings: haystack and needle.
 *				Find all the anagram of the needle within the haystack
 *
 * Solution:	Create sliding window, check the current sliding window is anagram of the input needle
 * Complexity:	O(n*256)
 * Notes:		Use HashMap if the input character is not ASCII
 *				
 * Follow up:	
 */
public class HaystackAndNeedle {
	
	public static void main(String[] arg){
		System.out.println(findAnagram("abcdbabcbbbbcad","acb"));
	}
	
	public static List<Integer> findAnagram(String haystack, String needle) {
		List<Integer> result = new ArrayList<Integer>();
		
		if (needle.length() > haystack.length()) 
			return result;
		
		char[] hChar = haystack.toCharArray();
		char[] nChar = needle.toCharArray();
		
		int[] hMap = new int[256];
		int[] nMap = new int[256];
		
		for (int i = 0; i < nChar.length; i++) {
			nMap[nChar[i]]++;
		}
		
		int count = 0;
		for (int i = 0; i < hChar.length; i++) {
			//remove char from sliding window
			if (i >= nChar.length) {
				int pos = i - nChar.length;
				char outChar = hChar[pos];
				if (nMap[outChar] > 0) { //the char has to be in the needle
					hMap[outChar]--;
					count--;
				}
			}
			
			char c = hChar[i];
			if (nMap[c] > 0) {
				count++;
				hMap[c]++;
			}
			
			//check anagram
			if (count == nChar.length && isAnagram(hMap, nMap)) {
				result.add(i - nChar.length + 1);
			}
		}
		
		return result;
	}
	
	private static boolean isAnagram(int[] a, int[] b) {
		for (int i = 0; i < 256; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
}
