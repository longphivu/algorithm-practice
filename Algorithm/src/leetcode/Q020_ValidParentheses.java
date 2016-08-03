package leetcode;

import java.util.Stack;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 2, 2016
 * Problem:		Q020_ValidParentheses.java
 * Source:		https://leetcode.com/problems/valid-parentheses/
 *
 * Description:	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
				The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Solution:	Use stack to store the open parentheses
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	(M) Generate Parentheses   (H) Longest Valid Parentheses   (H) Remove Invalid Parentheses  
 */
public class Q020_ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isValid("{[x]y()}"));

	}
	public static boolean isValid(String s) {
        boolean[] openning = new boolean[256];
        openning['('] = true;
        openning['{'] = true;
        openning['['] = true;
        char[] closingP = new char[256];
        closingP['('] = ')';
        closingP['{'] = '}';
        closingP['['] = ']';
       		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (openning[c]) //push to stack if open
				stack.push(c);
			else if (stack.isEmpty() || closingP[stack.pop()] != c) //return false immediately if found invalid closing
				return false;
		}

        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}
