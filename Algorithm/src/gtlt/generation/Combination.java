package gtlt.generation;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 16, 2016
 * Problem:		Combination.java
 * Source:		
 *
 * Description:	Generate all subsets of n elements with k size
 *
 * Solution:	First, generate the smallest subset  e.g. n = 5, k = 3 => "1,2,3"
 * 				Then scan from the last element, if the last element is smaller than largest possible at that position
 * 				E.g. at i 1 = 3 < n - k + i = 4, so we increase that element by 1 and set all elements after index 1 by
 * 				its smallest possible but greater than element at index 1. E.g. [1] = 2 -> [1] = 3 and [2] = 4, [3] = 5,...
 * Complexity:	O(n!)
 * Notes:		http://stackoverflow.com/questions/5363619/complexity-of-recursive-string-permutation-function
 *				
 * Follow up:	
 */
public class Combination {

	/** Generate all combinations from 1 to n with k elements
	 * @param n the range of number
	 * @param k how many elements in combination
	 */
	public static void iterative(int n, int k) {
		int[] arr = new int[k];
		//initialize smallest subset
		for (int i = 0; i < k; i++) {
			arr[i] = i+1;
		}
		printArray(arr);
		//start generate from the smallest subset
		for (int i = k-1; i >= 0; i--) {
			int max = n-k+i+1;
			if (arr[i] < max) {
				arr[i]++;
				int increment = 1;
				for (int j = i+1; j < k; j++) {
					arr[j] = arr[i] + increment;
					increment++;
				}
				printArray(arr);
				i = k;//reset i, start scanning from the end again
			}
		}
	}
	
	public static void recursive(int n, int k) {
		int[] arr = new int[k];
		tryReplace(arr, n, k, 0);
	}
	
	private static void tryReplace(int[] arr, int n, int k, int index) {
		if (index >= k) {
			printArray(arr);
			return;
		}
		
		int min = index > 0 ? arr[index-1]+1 : 0;
		int max = n - k + index;
		for (int i = min; i <= max; i++) {
			arr[index] = i;
			tryReplace(arr, n, k, index+1);
		}
	}
	
	public static void printArray(int[] arr) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		recursive(4, 3);
		//iterative(5, 3);
	}

}
