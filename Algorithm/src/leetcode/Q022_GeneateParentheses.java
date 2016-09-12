package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 12, 2016
 * Problem:		Q022_GeneateParentheses.java
 * Source:		https://leetcode.com/problems/generate-parentheses/
 *
 * Description:	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
				For example, given n = 3, a solution set is: 
				[
				  "((()))",
				  "(()())",
				  "(())()",
				  "()(())",
				  "()()()"
				]
 *
 * Solution:	DFS
 * Complexity:	O(n!) ?
 * Notes:
 *				
 * Follow up:	 (H) Longest Valid Parentheses   (M) Simplify Path   (H) Longest Substring with At Most Two Distinct Characters  
 */
public class Q022_GeneateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> solutions = new ArrayList<String>();
        
        if (n == 0) return solutions;
        
        StringBuilder sb = new StringBuilder();
        generate(solutions, sb, n, n);
        return solutions;
    }
    
    private static void generate(List<String> solutions, StringBuilder sb, int opening, int closing) {
        if (opening == 0 && closing == 0) {
            solutions.add(sb.toString());
            return;
        } 
        int len = sb.length();
        if (opening != 0) {
            generate(solutions, sb.append('('), opening - 1, closing);
            sb.setLength(len);
        }
        if (closing != 0 && closing > opening) {
            generate(solutions, sb.append(')'), opening, closing - 1);
            sb.setLength(len);
        }
    }
}
