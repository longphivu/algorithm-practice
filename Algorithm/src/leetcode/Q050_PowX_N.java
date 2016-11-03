package leetcode;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 3, 2016
 * Problem:		PowX_N.java
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
public class Q050_PowX_N {
	public static double myPow(double x, int n) {
        //return Math.pow(x, n);
        
        if (n == 0) return 1;
        if (n == 1) return x;
        
        double y = myPow(x, Math.abs(n/2));
        
        if (Math.abs(n) % 2 == 1) {
            x = y * y * x;
        } else {
            x = y * y;
        }
        
        if (n < 0) 
            return (1.0/x);
        return x;
    }
	
	public static void main(String...strings) {
		System.out.println(myPow(0.00001,2147483647));
		int n = Integer.MIN_VALUE;
		System.out.println(n);
		System.out.println(-n);
	}
}
