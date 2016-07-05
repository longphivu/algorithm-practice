package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q3_LongestSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring2("aaaa"));

	}
	public static int lengthOfLongestSubstring(String str) {
        int s = 0;
        int max = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(charMap.containsKey(c))
                s = Math.max(charMap.get(c)+1,s);
                
            charMap.put(c, i);
            
            if(i-s+1 > max)
                max = i-s+1;
        }
        
        return max;
    }
	 public static int lengthOfLongestSubstring2(String s) {
	        int max = 0;
	        int start = 0;
	        
	        int[] lastSeen = new int[256];
	        for(int i = 0; i<256; i++){
	            lastSeen[i] = -1;
	        }
	        
	        for(int i = 0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(lastSeen[c] != -1){
	                start = Math.max(lastSeen[c]+1, start);
	            }
	            lastSeen[c] = i;
	            max = Math.max(i-start+1, max);
	        }
	        
	        return max;
	    }
}
