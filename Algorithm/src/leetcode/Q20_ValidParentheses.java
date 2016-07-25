package leetcode;

import java.util.Stack;

public class Q20_ValidParentheses {

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
        boolean[] closing = new boolean[256];
        closing[')'] = true;
        closing['}'] = true;
        closing[']'] = true;
        char[] closingP = new char[256];
        closingP['('] = ')';
        closingP['{'] = '}';
        closingP['['] = ']';
       		
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(openning[c])
                stack.push(c);
            else if(closing[c]){
                if(stack.isEmpty() || closingP[stack.pop()] != c){
                    return false;
                }
            }
        }
        
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}
