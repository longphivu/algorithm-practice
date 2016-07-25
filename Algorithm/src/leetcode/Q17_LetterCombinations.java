package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 13, 2016
 * Problem:		Q17_LetterCombinations.java
 * Source:		https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Description:	Given a digit string, return all possible letter combinations that the number could represent. 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Solution:	1. Dynamic Programming: iterate through the digits, each time we get a new set of characters
 *				add it to each of the previous solution.
 *				2. Apply depth first search
 * Complexity:	O(n*m)
 * Notes:		
 *					
 * Follow up:	(M) Generate Parentheses   (M) Combination Sum  
 */
public class Q17_LetterCombinations {

	public static void main(String[] args) {
		letterCombinations("23");
	}

	public static List<String> letterCombinations(String digits) {
	        Map<Character, String> map = new HashMap<Character, String>();
	        populateLetter(map);
	        
	        List<String> solution = new ArrayList<String>();
	        
	        for(int i = 0; i < digits.length(); i++){
	            char ch = digits.charAt(i);
	            String letters = map.get(ch);
	            List<String> next = new ArrayList<String>();
	            for(int j = 0; j < letters.length(); j++){
	                if(solution.size() == 0){
	                    next.add(String.valueOf(letters.charAt(j)));
	                }
	                for(String s : solution){
	                    next.add(s+letters.charAt(j));
	                }
	            }
	            solution = next;
	        }
	        
	        return solution;
	    }
	
	public static List<String> letterCombinations2(String digits) {
        char[][] charMap = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        
        List<String> solution = new ArrayList<String>();
        
        if(digits != null && digits.length() > 0)
            dfs(digits, 0, new StringBuilder(), solution, charMap);
        
        return solution;
    }
    
	static void dfs(String digits, int level, StringBuilder sb, List<String> solutions, char[][] map){
        if(level >= digits.length()){
            solutions.add(sb.toString());
            return;
        }
        
        char ch = digits.charAt(level);
        char[] letters = map[ch-'0'];
        int len = sb.length();
        for(char c : letters){
            sb.append(c);
            dfs(digits, level+1, sb, solutions, map);
            sb.setLength(len);
        }
    }

	static void populateLetter(Map<Character, String> map){
		map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
	}
}
