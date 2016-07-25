package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 22, 2016
 * Problem:		Q205_IsomorphicStrings.java
 * Source:		https://leetcode.com/problems/isomorphic-strings/
 *
 * Description:	Given two strings s and t, determine if they are isomorphic.
				Two strings are isomorphic if the characters in s can be replaced to get t.
				All occurrences of a character must be replaced with another character while preserving the order of characters. 
				No two characters may map to the same character but a character may map to itself.
				For example,
				Given "egg", "add", return true.
				Given "foo", "bar", return false.
				Given "paper", "title", return true.
 *
 * Solution:	using 2 maps: first map to map the character from first string to second string; second map to check if the character 
 *				from second string has been map or not.	
 * Complexity:	O(n)
 * Notes:
 *					
 * Follow up:	(E) Word Pattern  
 */
public class Q205_IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "thh"));
		int[] sMap = new int[256];
		for(int i = 0; i<256; i++){
			sMap[i]=i;
		}
		System.out.println(sMap['*']);
	}

	public static boolean isIsomorphic(String s, String t) {

		if (s.length() != t.length())
			return false;

		char[] sMap = new char[256];
		char[] tMap = new char[256];
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if (sMap[sChar] == 0 && tMap[tChar] == '\0') {
				sMap[sChar] = tChar;
				tMap[tChar] = sChar;
			} else if (sMap[sChar] != tChar || tMap[tChar] != sChar) {
				return false;
			}
		}

		return true;
	}
}
