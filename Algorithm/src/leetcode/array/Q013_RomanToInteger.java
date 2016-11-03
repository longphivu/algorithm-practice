package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 3, 2016
 * Problem:		Q013_RomanToInteger.java
 * Source:		https://leetcode.com/problems/roman-to-integer/
 *
 * Description:	Given a roman numeral, convert it to an integer.
				Input is guaranteed to be within the range from 1 to 3999.
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Integer to Roman
 */
public class Q013_RomanToInteger {
	public int romanToInt(String s) {
        int[] value = new int[256];
        value['I'] = 1;     value['V'] = 5;
        value['X'] = 10;    value['L'] = 50;
        value['C'] = 100;   value['D'] = 500;
        value['M'] = 1000;
        
        int result = 0;
        
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (i != cs.length - 1 && value[c] < value[cs[i+1]]) {
                result += value[cs[i+1]] - value[c];
                i++;
            } else {
                result += value[c];
            }
        }
        
        return result;
    }
}
