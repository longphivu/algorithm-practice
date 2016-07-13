package leetcode;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com 
 * Date: 		Jul 13, 2016 
 * Problem: 	Q14_LongestCommonPrefix.java 
 * Source:		https://leetcode.com/problems/longest-common-prefix/
 *
 * Description: Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * Solution: 	1. Iterate through each character of the first string, if every string have the same char at specific index then 
 * 				add that char to solution.
 * 				2. Start at the mid of the first string, if every others string start with it, add to the solution then start to process
 * 				again with other half of the first string; otherwise start again with the first half.
 * Complexity: 	Time O(n*m), O(nlogm) 
 * Notes:		
 * 
 * Follow up: 	(H) Edit Distance (H) Interleaving String (H) Longest Substring with At Most Two Distinct Characters
 */
public class Q14_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		StringBuilder lcp = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (String s : strs) {
				if (s.length() < i + 1 || c != s.charAt(i)) //check length first to avoid out of bound exception
					return lcp.toString();
			}
			lcp.append(c);
		}
		return lcp.toString();
	}

	public static String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		String curWord = strs[0];
		while (!curWord.isEmpty()) {
			int mid = curWord.length() / 2;
			String word = curWord.substring(0, mid + 1);
			if (word.isEmpty())
				break;

			if (isCommonPrefix(strs, sb.toString() + word)) {
				sb.append(word);
				curWord = curWord.substring(mid + 1, curWord.length());
			} else {
				curWord = word.substring(0, word.length() - 1);
			}
		}
		return sb.toString();
	}

	public static boolean isCommonPrefix(String[] strs, String word) {
		for (String str : strs) {
			if (str.indexOf(word) == -1)
				return false;
		}
		return true;
	}

	public static void main(String[] arg) {
		String[] strs = { "acbc", "acb" };
		System.out.println(longestCommonPrefix(strs));
	}
}
