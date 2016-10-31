package leetcode.bit;

/**
 * Author:		
 * Date:		Oct 31, 2016
 * Problem:		Q260_SingleNumberIII.java
 * Source:		https://leetcode.com/problems/single-number-iii/
 *
 * Description:	Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
 * 				Find the two elements that appear only once. 
 *
 * Solution:	
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int xor = 0; //xor is the xor result of the two unique number
        
        //1: get the XOR of the two numbers we need to find. the duplicate ones will be canceled out(to 0), leaving the unique two left
        for(int n : nums){
            xor ^= n;
        }
        
        //2. find the right most set bit of the xor
        //can also do: int bit = xor & ~(xor-1);
        int mask = 1;
        while ((xor & mask) == 0) {
            mask = mask << 1;
        }
        
        int num1 = 0;
        int num2 = 0;
        
        int[] result = new int[2];
        //3. here we divide the originals nums into 2 group, 1 group has set bit the other group doesn't
        //note that numbers beside the single number will be canceled out 
        for (int num : nums) {
            if((num & mask) > 0) {
                num1 ^= num;
            }
            else{
                num2 ^= num;
            }
        }
        
        result[0] = num1;
        result[1] = num2;
        return result;
        
        
    }
}
