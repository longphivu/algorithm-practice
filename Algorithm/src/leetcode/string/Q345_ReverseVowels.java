package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 28, 2016
 * Problem:		Q345_ReverseVowels.java
 * Source:		https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Description:	Write a function that takes a string as input and reverse only the vowels of a string.
				Example 1:
				 Given s = "hello", return "holle". 
				Example 2:
				 Given s = "leetcode", return "leotcede". 
				Note:
				 The vowels does not include the letter "y". 
 * Solution:	search from head and tail vowels then swap them repeatedly
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q345_ReverseVowels {
	final static boolean[] vowels = new boolean[256];
    {
        vowels['a'] = true;        vowels['e'] = true;        vowels['i'] = true;        vowels['u'] = true;
        vowels['o'] = true;        vowels['A'] = true;        vowels['E'] = true;        vowels['I'] = true;
        vowels['U'] = true;        vowels['O'] = true;    
    }
    
    public String reverseVowels(String s) {
        char[] sc = s.toCharArray();
        
        int i = 0;
        int j = sc.length - 1;
        while (i < j) {
            //find head and tail vowels
            while (i < j && !vowels[sc[i]]) i++;
            while (i < j && !vowels[sc[j]]) j--;
            
            //no vowel or only one vowel
            if (i >= j) break;
            
            //swap them
            swap (sc, i, j);
            i++;
            j--;
        }
        
        return new String(sc);
    }
    
    private void swap(char[] sc, int from, int to) {
        char temp = sc[from];
        sc[from] = sc[to];
        sc[to] = temp;
    }
}
