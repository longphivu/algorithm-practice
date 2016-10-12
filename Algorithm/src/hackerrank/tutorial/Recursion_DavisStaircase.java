package hackerrank.tutorial;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 12, 2016
 * Problem:		Recursion_DavisStaircase.java
 * Source:		https://www.hackerrank.com/challenges/ctci-recursive-staircase
 *
 * Description:	Davis has s staircases in his house and he likes to climb each staircase 1, 2, or 3 steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
				Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase on a new line. 
 * Solution:	Calculate how many way he can make if the first step is 1, 2, or 3
 * 				Eg. f(4) = f(3) + f(2) + f(1)
 * 				
 * Complexity:	O(n)
 * Notes:		0 staircase can be either 0 or 1 way to finish it, in this solution I use 1
 *				
 * Follow up:	
 */
public class Recursion_DavisStaircase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(solve(n));
        }
        in.close();
    }
	
	public static int solve(int n) {
		return solve(n, 1, 1, 2);
	}
	
	private static int solve(int n, int f0, int f1, int f2) {
		if (n == 0) return f0;
		if (n == 1) return f1;
		if (n == 2) return f2;
		return solve(n-1, f1, f2, f0+f1+f2);
	}
}
