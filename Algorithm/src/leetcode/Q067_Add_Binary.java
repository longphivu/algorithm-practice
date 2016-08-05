package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 5, 2016
 * Problem:		Q067_Add_Binary.java
 * Source:		https://leetcode.com/problems/add-binary/
 *
 * Description:	Given two binary strings, return their sum (also a binary string). 
				For example,
				 a = "11"
				 b = "1"
				 Return "100". 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Multiply Strings  
 */
public class Q067_Add_Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1";
		String b = "1";
		System.out.println(addBinary(a, b));
	}

	static char carry = '0';

	public static String addBinary(String a, String b) {

		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		char[] result = new char[Math.max(ac.length, bc.length) + 1];

		int i = ac.length - 1;
		int j = bc.length - 1;
		int k = result.length - 1;
		while (i >= 0 || j >= 0) {
			char sum = carry; // use carry first in case new carry arise
			carry = '0';

			char bit1 = (i >= 0) ? ac[i] : '0';
			char bit2 = (j >= 0) ? bc[j] : '0';
			sum = addBinary(sum, addBinary(bit1, bit2));

			result[k--] = sum;

			i--;
			j--;
		}

		if (carry == '1') {
			result[0] = '1';
			return new String(result);
		} else {
			return new String(result, 1, result.length-1);
		}
	}

	public static char addBinary(char a, char b) {
		if (a == '0' && b == '0')
			return '0';

		if (a == '0' && b == '1' || a == '1' && b == '0')
			return '1';

		// a == 1, b == 1;
		carry = '1';
		return '0';
	}
}
