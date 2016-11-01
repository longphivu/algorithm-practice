package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q028_Implement_strStr.java
 * Source:		https://leetcode.com/problems/implement-strstr/
 *
 * Description:	implement strStr().
				Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q028_Implement_strStr {
	public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int checkLen = haystack.length() - needle.length();
        for(int i = 0; i<=checkLen; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                for(int j = 0; j<needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }
                    if(j==needle.length()-1) return i;
                }
            }
        }
        
        return -1;
    }
}
