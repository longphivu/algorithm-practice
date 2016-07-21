package leetcode;

import java.util.Stack;

/**
 * Author: 		Long Vu, longvu.cs@outlook.com
 * Date: 		Jul 21, 2016
 * Problem: 	Q150_EvaluateReversePolishNotation.java
 * Source:		https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Description:	Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
				Valid operators are +, -, *, /. Each operand may be an integer or another expression. 
				Some examples:
  				["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  				["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Solution:	Use stack to store the operands, pop two top element and evaluate each time getting an expression
 * Complexity:	O(n)
 * Notes:	
 *					
 * Follow up:	(H) Basic Calculator   (H) Expression Add Operators  
 */
public class Q150_EvaluateReversePolishNotation {
	 public int evalRPN(String[] tokens) {
	        String exps = "+-/*";
	        Stack<Integer> stack = new Stack<Integer>();
	        for(String token : tokens){
	            int i = exps.indexOf(token);
	            if(i != -1){
	                char exp = exps.charAt(i);
	                int op1 = stack.pop();
	                int op2 = stack.pop();
	                switch(exp){
	                    case '+': stack.push(op1 + op2); break;
	                    case '-': stack.push(op2 - op1); break;
	                    case '*': stack.push(op1 * op2); break;
	                    case '/': stack.push(op2 / op1); break;
	                }
	            } else {
	                stack.push(Integer.valueOf(token));
	            }
	        }
	        return stack.pop();
	    }
}
