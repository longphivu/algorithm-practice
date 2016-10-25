package leetcode.array;
/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 21, 2016
 * Problem:		Q189_RotateArray.java
 * Source:		https://leetcode.com/problems/rotate-array/
 *
 * Description:	Rotate an array of n elements to the right by k steps.
				For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
 *
 * Solution:	1. Array copy, O(n) space
 *				2. Shift element, O(1) space
 *				3. Reverse, best ?
 * Complexity:	O(n) or O(n*k)
 * Notes:
 *					
 * Follow up:	(M) Rotate List   (M) Reverse Words in a String II  
 */
public class Q189_RotateArray {
	public static void main(String[] agr){
		int[] arr = {1,2,3,4,5,6};
		int k = 4;
		//rotateByReverse(arr, k);
		rotateByCopy(arr, k);
		print(arr);
	}
	
	public static void rotateByCopy(int[] arr, int k){
		int len = arr.length;
		int[] result = new int[len];
		System.arraycopy(arr, len-k, result, 0, k);
		System.arraycopy(arr, 0, result, k, len-k);
		System.arraycopy(result, 0, arr, 0, len);
		
	}
	
	public static void rotateByReverse(int[] arr, int k) {
		int len = arr.length;
		k = k % len;
		reverse(arr, len-k, len-1); //reverse last k item
		reverse(arr, 0, len-k-1); //reverse first len-k item
		reverse(arr, 0, len-1);//reverse whole array
	}

	public static void reverse(int[] arr, int start, int end) {
		if (start >= 0 && end < arr.length && start < end) {
			while (start < end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
	}
	
	public static void print(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
	}
}
