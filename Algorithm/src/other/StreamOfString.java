package other;

import java.util.LinkedList;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 14, 2016
 * Problem:		StreamOfString.java
 * Source:		
 *
 * Description:	Given a endless stream of string, and a method that receives a char and return a char, implement that method so that
 * 				it will return '1' instead of '0' if the string have 3 consecutive '0's
 * 				You will not know what is coming after first '0'
 *
 * Solution:	Use buffer delay the return process for k = 3 characters, count the zero
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class StreamOfString {
	public static void main(String... a) {
		String s = "af000asd0000s0a000af";
		
		String r = solve(s);
		System.out.println(r);
	}
	static LinkedList<Character> buffer = new LinkedList<>();
	public static String solve(String s) {
		for (int i = 0; i < 3; i++) {
			if (s.charAt(i) == '0') zeroCount++;
			buffer.offer(s.charAt(i));
		}
		StringBuilder ret = new StringBuilder();
		for (int i = 3; i < s.length(); i++) {
			ret.append(back(s.charAt(i)));
		}
		return ret.toString();
	}
	
	static int zeroCount = 0;
	static int tempCount = 0;
	static boolean isConvert = false;
	public static char back(char c) {
		char front = buffer.pollFirst();
		
		if (zeroCount == 3 && !isConvert) 
			isConvert = true;
		
		char ret = front;
		
		if (front == '0') {
			zeroCount--;
			if (isConvert)
				ret = '1';
		}
		
		if (c == '0') {
			if (!isConvert)
				zeroCount++;
			else 
				tempCount++;
		}
		
		if (zeroCount == 0) {
			isConvert = false;
			zeroCount = tempCount;
		}
		
		buffer.offerLast(c);
		
		return ret;
		
	}
}
