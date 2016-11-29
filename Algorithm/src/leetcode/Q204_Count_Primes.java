package leetcode;

import java.util.Arrays;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 29, 2016
 * Problem:		Q204_Count_Primes.java
 * Source:		https://leetcode.com/problems/count-primes/
 *
 * Description:	Count the number of prime numbers less than a non-negative number, n.
 *
 * Solution:	Apply Sieve of Eratosthenes algorithm, for each prime find its multiplier and mark as false
 * 				https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * Complexity:	O(n log log n)
 * Notes:
 *				
 * Follow up:	
 */
public class Q204_Count_Primes {
	public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
        	if (!isPrime[i]) continue;
        	
            for (int j = i*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) cnt++;
        }
        return cnt;
    }
}
