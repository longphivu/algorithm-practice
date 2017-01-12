package hackerrank;

import java.util.Scanner;

public class ScannerUtility {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }
	
	public static int[] scanArray(int n, Scanner in) {
		int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        return a;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
