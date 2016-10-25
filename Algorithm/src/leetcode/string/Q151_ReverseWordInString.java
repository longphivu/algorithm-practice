package leetcode.string;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 21, 2016
 * Problem:		Q151_ReverseWordInString.java
 * Source:		https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Description:	Given an input string, reverse the string word by word. 
				For example,
				Given s = "the sky is blue",
				return "blue is sky the". 
 *
 * Solution:	Reverse each word we scan, then reverse the whole sentence
 * Complexity:	O(n)
 * Notes:		only keep 1 space between words
 *					
 * Follow up:	(M) Reverse Words in a String II  
 */
public class Q151_ReverseWordInString {

	public static void main(String[] args) {
		String s = "  a  bc ";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		if(s == null) return "";
       
        char[] chrs = s.toCharArray();
        
        int left = 0; //left bound
        int right = chrs.length - 1; //right bound
        while(left <= right && chrs[left] == ' ') left++; //skip leading spaces
        while(right >= left && chrs[right] == ' ') right--; //skip trailing spaces
        
        int start = 0, end = 0, next = left;
        for(int i = left; i <= right; i++){
            while(i <= right && chrs[i] == ' ') i++; //skip spaces
            start = i;
            while(i <= right && chrs[i] != ' ') i++; //then skip chars
            end = i - 1;
            
            reverse(chrs, start, end);
            
            if(start != next){
                //shift back from start to end, starting from next;
                while(start <= end){
                    chrs[next++] = chrs[start++];
                }
                //after loop next  == end + 1;
                chrs[next] = ' '; // add one space
                next += 1;
            }
            else {
                next = end + 2; //no shift, ensure next word position is always 2 index ahead or last word
            }
        }
        
        if(next <= left) return ""; //no word detected
        
        right = next - 2;
        reverse(chrs, left, right);
        return new String(chrs, left, right-left+1);
    }
    
    public static void reverse(char[] chrs, int start, int end){
        while( start >= 0 && end < chrs.length && start < end){
            char temp = chrs[start];
            chrs[start] = chrs[end];
            chrs[end] = temp;
            start++;
            end--;
        }
    }
}
