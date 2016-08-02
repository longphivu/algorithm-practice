package leetcode;

/**
 * Author:		
 * Date:		Jul 13, 2016
 * Problem:		Q5_LongestPalindromicSubstring.java
 * Source:		https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Description:	
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * Solution:	http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 *				Dynamic Programming: using two dimension table to store the solution of inner string and use it to calculate the next/boundary string
 *				Other solution: iterate through each of character of the string to find the maximum palindrome at each char
 *				
 * Complexity:	Time O(n^2), Space O(n^2) or O(1)
 * Notes:		For research purpose: Manacher's Algorithm - O(n) Time
 *					
 * Follow up:	(H) Shortest Palindrome   (E) Palindrome Permutation   (H) Palindrome Pairs 		
 */
public class Q005_LongestPalindromicSubstring {

	public static void main(String[] args) {
		//System.out.println(simple("a"));
		System.out.println(dynamic("aa"));
	}
	
	public static String dynamic(String s){
		if(s == null || s.isEmpty()) return "";
		
		int start = 0, end = 1;
		int len = s.length();
		boolean[][] table = new boolean[len][len];
		
		for(int i = 1; i < len; i++){
			table[i][i] = true;//every single char is palindrome
			if(s.charAt(i) == s.charAt(i-1)){ //check for 2 consecutive chars 
				table[i-1][i] = true; 
				start = i-1;
				end = i+1;
			}
		}
		
		//start checking for substring that has length >= 3 
		for(int l = 1; l < len; l++){ // l is inner string
			for(int i = 0; i<len-l-1; i++){
				int j = i+l+1; // i and j are outter bound
				if(s.charAt(i) == s.charAt(j) && table[i+1][j-1] == true){ //if the inside is palindrome and outer bound is the same
					table[i][j]=true;
					start = i;
					end = j+1;
				} 
			}
		}
		
		return s.substring(start, end);
	}

	public static String simple(String s){
		int max = 0;
		int start = 0, end = 0;
		for(int i = 0; i<s.length(); i++){
			int l1 = palindromeHelper(s, i, i);
			int l2 = palindromeHelper(s, i, i+1);
			if(l1 > max){
				max = l1;
				start = i-l1/2;
				end = i+l1/2;
			}
			if(l2 > max){
				max = l2;
				start = i+1-l2/2;
				end = i+l2/2;
			}
		}
		return s.substring(start, end+1);
	}
	
	public static int palindromeHelper(String st, int s, int e){
		while(s >= 0 && e < st.length() && st.charAt(s) == st.charAt(e)){
			s--;e++;
		}
		return e-s-1;
	}
}
