package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 28, 2016
 * Problem:		Q385_NestedInteger.java
 * Source:		https://leetcode.com/problems/mini-parser/
 *
 * Description:	Given a nested list of integers represented as a string, implement a parser to deserialize it.
				Each element is either an integer, or a list -- whose elements may also be integers or other lists.
				Note: You may assume that the string is well-formed: 
				•String is non-empty.
				•String does not contain white spaces.
				•String contains only digits 0-9, [, - ,, ].
 * Solution:	Split string to multiple small strings and recursive solve it
 * Complexity:	O(n) ?
 * Notes:
 *				
 * Follow up:	(M) Flatten Nested List Iterator   (M) Ternary Expression Parser  
 */
public class Q385_MiniParser {
	
	public static void main(String[] ag) {
		Q385_MiniParser q = new Q385_MiniParser();
		q.deserialize("[1,[3],2]");
	}
	
	public NestedInteger deserialize(String s) {
        NestedInteger ni = new NestedInteger();
        
        if (s.charAt(0) == '[') {
            List<String> list = split(s);
            for (String str : list) {
                ni.add(deserialize(str));
            }
        } else {
            ni.setInteger(Integer.valueOf(s));
        }
        
        return ni;
    }
    
    private List<String> split(String s) {
        //ignore open and close braces
        int from = 1;
        int to = s.length()-1;
        
        List<String> list = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        while(from < to) {
            char c = s.charAt(from);
            //if encounter an openning brace, scan until we get corresponding closing brace
            if (c == '[') {
                int i = from + 1;
                int openBrace = 1;
                int closeBrace = 0;
                while (i < to) {
                    if (s.charAt(i) == '[')
                        openBrace++;
                    if (s.charAt(i) == ']')
                        closeBrace++;
                    if (openBrace == closeBrace)
                        break;
                    i++;
                }
                list.add(s.substring(from, i+1));
                from = i;
            } else if (c != ',') {
                //keep adding digit
                sb.append(c);
            } else if (sb.length() != 0) {
                //reach end of current number
                list.add(sb.toString());
                sb.setLength(0);
            }
            
            //reach end, check last number
            if (from == to-1 && sb.length() != 0) {
                list.add(sb.toString());
            }
                        
            from++;
        }
        
        return list;
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedInteger {
	
	 Integer val;
	 NestedInteger next;
     // Constructor initializes an empty nested list.
     public NestedInteger(){
    	 val = null;
     }

     // Constructor initializes a single integer.
     public NestedInteger(int value){
    	 val = value;
     };

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger(){
    	 return true;
     };

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger(){
    	 return val;
     };

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value){
    	 val = value;
     };

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni){
    	 next = ni;
     };

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList(){
    	 return null;
     };
 }
