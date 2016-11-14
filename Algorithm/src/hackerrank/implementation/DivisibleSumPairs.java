package hackerrank.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 14, 2016
 * Problem:		DivisibleSumPairs.java
 * Source:		https://www.hackerrank.com/challenges/divisible-sum-pairs
 *
 * Description:	The first line contains 2 space-separated integers, n and k, respectively.
				The second line contains n space-separated integers describing the respective values of 
 *				Print the number of pairs (i, j) where i < j and ai + aj is evenly divisible by k.
 * Solution:	Similar to 2 sum, use map to store remainder
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class DivisibleSumPairs {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int a[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        
        int totalPair = 0;
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            int remainder = a[a_i]%k;
            //find if there is any number that satisfied 
            int need = (k - remainder) % k;
            int needFreq = map.getOrDefault(need, 0);
            totalPair += needFreq;
            
            //put current remainder
            int remainderFreq = map.getOrDefault(remainder, 0);
            map.put(remainder, remainderFreq + 1);
        }
        
        System.out.println(totalPair);
    }
}
