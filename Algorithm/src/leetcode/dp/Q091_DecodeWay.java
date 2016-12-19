package leetcode.dp;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Dec 19, 2016
 * Problem:		Q091_DecodeWay.java
 * Source:		https://leetcode.com/problems/decode-ways/
 *
 * Description:	A message containing letters from A-Z is being encoded to numbers using the following mapping:
				'A' -> 1
				'B' -> 2
				...
				'Z' -> 26
				Given an encoded message containing digits, determine the total number of ways to decode it.
				
				For example,
				Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
				The number of ways decoding "12" is 2. 
 *
 * Solution:	DP, current number of solution at position n is equal to sum of total solution at n-1 and n-2
 * Complexity:  O(n) time, O(n) space
 * Notes:		
 *				
 * Follow up:	
 */
public class Q091_DecodeWay {
	 public int numDecodings(String s) {
		 int n = s.length();

		 if (n == 0) return 0;
		 
		 int[] dp = new int[n+1];
		 dp[n] = 1;
		 dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
		 
		 for (int i = n-2; i >= 0; i--) {
			 if (s.charAt(i) == '0') 
				 continue;
			 else 
				 dp[i] = (Integer.parseInt(s.substring(i, i+2)) <= 26) ? dp[i+2] + dp[i+1] : dp[i+1];
		 }
		 
		 return dp[0];
	 }
}
