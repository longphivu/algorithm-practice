package gtlt.enhancebacktracking;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 18, 2016
 * Problem:		NoRepeatSubstring.java
 * Source:		
 *
 * Description:	Given 3 character 'A', 'B', 'C' and integer N build a string with these rules:
 * 				1. String has N length
 * 				2. Any pair of consecutive substrings are different
 * 				3. Use least amount of 'C' character 
 *
 * Solution:	If string X = X1X2X3...Xn has no equal consecutive substrings then every 4 characters must have at least one character 'C'
 * 				Hence, a string with k character must have at least k/4 'C' character.
 * 				We use this one to check if our current solution is good enough to continue solving
 * 				If Ti + (N - i) <= best_min then continue solving
 * 				where Ti	  : current 'C' count
 * 					  N		  : length of desire string
 * 					  i		  : current solution length
 * 			          best_min: current best solution with least 'C'	
 * Complexity:	O(n!)
 * Notes:
 *				
 * Follow up:	
 */
public class NoRepeatSubstring {

	static int cMin = Integer.MAX_VALUE;
	static String result = "";
	public static String solve(int n) {
		StringBuilder sb = new StringBuilder();
		tryBuildString(sb, n, 0);
		return result;
	}
	
	private static void tryBuildString(StringBuilder sb, int n, int cCnt) {
		if (sb.length() == n) { //reach result
			if (cCnt < cMin) {
				cMin = cCnt;
				result = sb.toString();
			}
			return;
		}
		
		for (char c = 'A'; c <= 'C'; c++) {
			int len = sb.length();
			sb.append(c);
			if (canPlace(sb)) {
				//only continue if current solution can be solve with best result
				if (cCnt + (n - sb.length()) / 4 < cMin) 
					if (c == 'C')
						tryBuildString(sb, n, cCnt+1);
					else
						tryBuildString(sb, n, cCnt);
			}
			sb.setLength(len);//backtrack, remove last character
		}
	}
	
	private static boolean canPlace(StringBuilder sb) {
		int len = sb.length();
		
		if (len < 2) 
			return true;

		for (int l = 1; l <= len/2; l++) {
			if (hasSame(sb, l))
				return false;
		}
		
		return true;
	}
	
	private static boolean hasSame(StringBuilder sb, int len) {
		int i = sb.length() - 1;
		int j = i - len;
		//we only need to check the last pair in the string to see whether new character breaks our condition
		for (int k = 0; k < len; k++) {
			if (sb.charAt(i-k) != sb.charAt(j-k))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(100));
		System.out.println(cMin);
	}

}
