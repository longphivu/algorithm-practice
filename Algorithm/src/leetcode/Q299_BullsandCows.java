package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 23, 2016
 * Problem:		Q299_BullsandCows.java
 * Source:		https://leetcode.com/problems/bulls-and-cows/
 * Description:	You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. 
 * 				Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in 
 * 				both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). 
 * 				Your friend will use successive guesses and hints to eventually derive the secret number.
				For example: 
				Secret number:  "1807"
				Friend's guess: "7810"
				Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.) 
				Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B". 
				Please note that both secret number and friend's guess may contain duplicate digits, for example: 
				Secret number:  "1123"
				Friend's guess: "0111"
				In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B". 
				You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * Solution:	Count bulls and cows in different iterations
 * Complexity:	O(n)
 * Notes:	
 *				
 * Follow up:	(H) Longest Substring with At Most Two Distinct Characters   (E) Strobogrammatic Number   (M) H-Index  
 */
public class Q299_BullsandCows {
	public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] sarray = secret.toCharArray();
        char[] garray = guess.toCharArray();
        int[] smap = new int[10];
        int[] gmap = new int[10];
        
        //count bulls, if not bull then get appearance frequency;
        for (int i = 0; i < garray.length; i++) {
            if (sarray[i] == garray[i]) {
                bulls++;
            } else {
                smap[sarray[i]-'0']++;
                gmap[garray[i]-'0']++;
            }
        }
        
        //count cows
        for (int i = 0; i < 10; i++) {
            cows += Math.min(smap[i], gmap[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
