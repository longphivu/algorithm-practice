package hackerrank.tutorial;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 11, 2016
 * Problem:		Strings_MakingAnagrams.java
 * Source:		https://www.hackerrank.com/challenges/ctci-making-anagrams
 *
 * Description:	Input Format
  				- The first line contains a single string, . 
				- The second line contains a single string, .
				Constraints 
				- 1 <= a,b <= 10^4
				- It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).
				
				Output Format
				- Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.
 * Solution:	count char frequency, count the difference
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Strings_MakingAnagrams {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(numberNeeded(a, b));
    }
    
    public static int numberNeeded(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        
        int[] aCnt = new int[256];
        int[] bCnt = new int[256];
        
        for (int i = 0; i < aChars.length; i++) {
            aCnt[aChars[i]]++;
        }
        
        for (int i = 0; i < bChars.length; i++) {
            bCnt[bChars[i]]++;
        }
        
        int result = 0;
        for (int i = 0; i < 256; i++) {
            result += Math.abs(aCnt[i] - bCnt[i]);
        }
        
        return result;
    }
}
