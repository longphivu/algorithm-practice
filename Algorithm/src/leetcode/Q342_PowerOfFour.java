package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 15, 2016
 * Problem:		Q342_PowerOfFour.java
 * Source:		https://leetcode.com/problems/power-of-four/
 *
 * Description:	Given an integer (signed 32 bits), write a function to check whether it is a power of 4. 
				Example:
 				Given num = 16, return true. Given num = 5, return false. 
				Follow up: Could you solve it without loops/recursion? 
 *
 * Solution:	- Calculate result of logarithm base 4
 * 				- Other solution: check every last 2 bit of number, if other than 0 return false (e.g: 4^2 = 2^4 = 10000)
 * Complexity:	O(1) 
 * Notes:
 *				
 * Follow up:	(E) Power of Three  
 */
public class Q342_PowerOfFour {
	public boolean isPowerOfFour(int num) {
        if (num < 1) return false;
        while ((num & 3) == 0) 
            num = num >>> 2;
        return num == 1;
    }
	
	public boolean isPowerOfFourFollowUp(int num) {
        if (num < 1) return false;

        double powerValue = Math.log(num)/Math.log(4);
        
        //return (powerValue % 1) == 0;
        if (powerValue == (int) powerValue)
            return true;
        else
            return false;
    }
}
