package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 21, 2016
 * Problem:		Q049_GroupAnagrams.java
 * Source:		https://leetcode.com/problems/anagrams/
 *
 * Description:	Given an array of strings, group anagrams together. 
				For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
				 Return: 
				[
				  ["ate", "eat","tea"],
				  ["nat","tan"],
				  ["bat"]
				]
 * Solution:	Sort input strings, use them as a key to identify other anagram
 * Complexity:	O(n^2), O(n^2 logn) if use quicksort
 * Notes:
 *				
 * Follow up:	(E) Group Shifted Strings  
 */
public class Q049_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        //sorted string will be key, value is list of original strings
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortStr(str);
            List<String> groupAnagram;
            if (!strMap.containsKey(sortedStr)) {
                groupAnagram = new ArrayList<>();
                strMap.put(sortedStr, groupAnagram);
                results.add(groupAnagram);
            } else {
                groupAnagram = strMap.get(sortedStr);
            }
            groupAnagram.add(str);
        }
        
        return results;
    }
    //bucketsort, since all inputs are lower case character
    public String sortStr(String str) {
        char[] chars = str.toCharArray();
        
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            count[c - 'a']++;
        }
        
        int i = 0;
        for (char j = 0; j < 26; j++) {
            while (count[j] != 0) {
                chars[i++] = (char) (j + 'a');
                count[j]--;
            }
        }
        
        return String.valueOf(chars);
    }
}
