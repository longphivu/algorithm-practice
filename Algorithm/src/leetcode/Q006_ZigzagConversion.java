package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 15, 2016
 * Problem:		Q6_ZigzagConversion.java
 * Source:		https://leetcode.com/problems/zigzag-conversion/
 *
 * Description:	
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility) 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows: 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 * 
 * Solution:	1. Straight forward: use 1 pointer to move back and fort between the lines.
 *						
 * Complexity:	O(n)
 * Notes:
 *					
 * Follow up:	(H) Wildcard Matching   (M) Encode and Decode Strings   (E) Reverse Vowels of a String  
 */
public class Q006_ZigzagConversion {
	public String convert(String s, int nRows) {
        if (nRows <= 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int step = 2*(nRows-1);
        for (int i = 0; i < nRows; i++) {
            int j = i;
            if (i == 0 || i == nRows-1) { //first and last rows
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += step;
                }
            } else { //middle rows
                int step1 = 2*(nRows-1 - i);
                int step2 = 2*i;
                boolean flag = true;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += flag ? step1 : step2;
                    flag = !flag;
                }
            }
        }
        
        return sb.toString();
    }

	public static String convert2(String s, int nRows) {
		if (nRows <= 1)
			return s;
		
		int period = (nRows << 1) - 2;
		char[] array = s.toCharArray();

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			int j = i;
			int move = 0, temp = 0;

			while (j < array.length) {
				result = result.append(array[j]);
				if (i != 0 && i != nRows - 1) {
					temp = (j % period);
					move = (temp < nRows) ? (nRows - 1 - temp) << 1 : (period - temp) << 1;
					j += move;
				} else {
					j += period;
				}
			}
		}

		return result.toString();
	}
	
	public static void main(String[] agr){
		System.out.println(convert2("abcdefghi",2));
	}
}
