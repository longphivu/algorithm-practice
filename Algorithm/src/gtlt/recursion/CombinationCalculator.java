package gtlt.recursion;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 21, 2016
 * Problem:		CombinationCalculator.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class CombinationCalculator {

	public static int solve(int n, int k) {
		if (k == 0) return 1;
		if (k == n) return 1;
		return solve(n-1, k-1) 
				+ solve(n-1, k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5,3));
	}

}
