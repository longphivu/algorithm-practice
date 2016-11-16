package other;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 13, 2016
 * Problem:		CombinationGenerator.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	Combinations are generated in lexicographical order. Algorithms uses indexes of the elements of set.
				Here is how it works on example: 
				Suppose we have a set of 5 elements with indexes 1 2 3 4 5 (starting from 1) and we need to generate all combination size m = 3.
				First we initialize first combination size m - indexes in ascending order
				1 2 3
				We start from checking the last element (i.e. i = 3). If its value less than n - m + i, it is incremented by 1.
				1 2 4
				Again we check last element, and, since it is still less than n - m + i, it is incremented by 1.
				1 2 5
				Now it has the maximum allowed value: n - m + i = 5 - 3 + 3 = 5, so we move on to the previous element (i = 2).
				If its value less than n - m + i, it is incremented by 1, and all following elements are set to value of their previous neighbor plus 1
				1 (2+1)3 (3+1)4 = 1 3 4
				Then we again start from the last element i = 3
				1 3 5
				Back to i = 2
				1 4 5
				Now it finally equals n - m + i = 5 - 3 + 2 = 4, so we can move to first element (i = 1)
				(1+1)2 (2+1)3 (3+1)4 = 2 3 4
				And then,
				2 3 5
				2 4 5
				3 4 5 - last combination since all values are set to the maximum possible values of n - m + i.

 * Complexity:
 * Notes:		Credit goes to http://planetcalc.com/3757/
 *				
 * Follow up:	
 */
public class CombinationGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"A","B","C","D"};
		generate(a, 2);
	}
	
	static void generate(Object[] a, int m){
		int n = a.length;
		
		int[] pos = new int[m];
		
		for(int i = 0; i < m; i++){
			pos[i] = i;
		}
		
		print(a, pos);
		
		for (int i = m-1; i >= 0; i--) {
			if (pos[i] < n-m+i) {
				pos[i]++;
				int inc = 1;
				for (int j = i+1; j < m; j++) {
					pos[j] = pos[i] + inc;
					inc++;
				}
				i = m;
				print(a, pos);
			}
		}
		
	}
	

	static void print(Object[] o, int[] a){
		for(int i : a){
			System.out.print(o[i]+" ");
		}
		System.out.println();
	}
}
