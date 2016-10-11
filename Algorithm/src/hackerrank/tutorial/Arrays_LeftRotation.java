package hackerrank.tutorial;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 11, 2016
 * Problem:		Arrays_LeftRotation.java
 * Source:		https://www.hackerrank.com/challenges/ctci-array-left-rotation
 *
 * Description:	Given an array of  integers and a number, , perform  left rotations on the array. 
 * 				Then print the updated array as a single line of space-separated integers.
 *
 * Solution:	Reverse array
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class Arrays_LeftRotation {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        
        k = k % n;
        reverse(a, 0, k-1);
        reverse(a, k, n-1);
        reverse(a, 0, n-1);
        
        for(int a_i=0; a_i < n; a_i++){
            System.out.print(a[a_i] + " ");
        }
    }
    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1) 
            return;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }	
    }
}
