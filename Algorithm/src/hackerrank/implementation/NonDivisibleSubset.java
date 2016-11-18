package hackerrank.implementation;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 14, 2016
 * Problem:		NonDivisibleSubset.java
 * Source:		https://www.hackerrank.com/challenges/non-divisible-subset
 *
 * Description:	Given a set S or n distinct integer, print the size of sub set S' of S where the sum of any 2 numbers in S'
 * 				are not evenly divisible by k
 *
 * Solution:	Count the remainder frequency, get max between 2 remainders that sum to k
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class NonDivisibleSubset {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = scanArray(n, in);
        System.out.println(solve(arr, k));
    }
    
    public static int solve(int[] arr, int k) {
        if (arr.length < 1) return 0;
        
        int[] remainderMap = new int[k];
        //count the remainder frequency
        for (int value : arr) {
            int remainder = value % k;
            remainderMap[remainder]++;
        }
        //get the maximum between divisible remainder pair
        int setSize = 0;
        int start = 1;
        int end = k-1;
        while (start <= end) {
            if (start == end && remainderMap[start] != 0) {
                setSize++; //only add 1 number to the set for the middle pair 
                           //ie. k = 4, [2,2,0,1,3] -> add one 2 to final set only
            } else {
                int max = Math.max(remainderMap[start], remainderMap[end]);
                setSize += max;
            }
            start++;
            end--;
        }
        
        if (remainderMap[0] != 0)
            setSize++;//same for middle remainder, only add one value with remainder equals 0
        
        return setSize;
    }
    
    public static int[] scanArray(int n, Scanner in) {
		int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        return a;
	}
}
