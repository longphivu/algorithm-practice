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
}
