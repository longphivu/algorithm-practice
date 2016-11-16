package gtlt.generation;

import java.util.Arrays;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 16, 2016
 * Problem:		BinaryString.java
 *
 * Description:	Generate all possible binary string with given length  
 *
 * Solution:	First we generate the first/smallest binary string e.g. '000'
 * 				Then we scan from the last to first, flip the first '0' then set all element behind that '0' to '0'
 * 				And scan from the last again
 * Complexity:	Exponential O(2^n)
 * Notes:
 *				
 * Follow up:	
 */
public class BinaryString {

	public static void iterative(int n) {
		char[] str = new char[n];
		Arrays.fill(str, '0');
		System.out.println(str);
		for (int i = n-1; i >= 0; i--) {
			if (str[i] == '0') {
				str[i] = '1';
				for (int j = i+1; j < n; j++) {
					str[j] = '0';
				}
				System.out.println(str);
				i = n;
			}
			
		}
		
	}
	
	public static void recursive(int n) {
		char [] str = new char[n];
		
		Arrays.fill(str, '0');
		
		//System.out.println(str);
		
//		for (int i = 0; i < n; i++) {
//			str[i] = flip(str[i]);
//			recursiveHelper(str, i+1);
//			str[i] = flip(str[i]);
//		}
		tryBinary(str, 0);
	}
	
	public static void tryBinary(char[] str, int index) {
		
		if (index >= str.length) {
			System.out.println(str);
			return;
		}
		
		str[index] = '0';
		tryBinary(str, index+1);
		
		str[index] = '1';
		tryBinary(str, index+1);
		
	}
	
	
	public static void recursiveHelper(char[] str, int index) {
		System.out.println(str);
		
		if (index >= str.length)	return;
		
		for (int i = index; i < str.length; i++) {
			str[i] = flip(str[i]);
			recursiveHelper(str, i+1);
			str[i] = flip(str[i]);
		}
	}
	
	public static char flip(char c) {
		if (c == '0') return '1';
		return '0';
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		recursive(3);
		long end = System.currentTimeMillis();
		System.out.printf("Recursive: %dms\n", (end-start));
		
		start = System.currentTimeMillis();
		//iterative(2);
		end = System.currentTimeMillis();
		System.out.printf("Iterative: %dms\n", (end-start));
		
	}

}
