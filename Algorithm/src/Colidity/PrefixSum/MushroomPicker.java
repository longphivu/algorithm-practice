package Colidity.PrefixSum;

public class MushroomPicker {
	public static int solve(int[] A, int k, int m){
		int n = A.length;
		int result = 0;

		int[] pref = new int[n];
		for(int i = 0; i<n; i++){
			pref[i] = (i == 0) ? A[i] : A[i]+pref[i-1];
		}
		
		int lmove = k >= m ? m : k;
		int rmove;
		while(lmove >= 0){
			rmove = Math.max(0, m-2*lmove);
			if(rmove+k >= n) break;
			int ltotal = pref[k] - pref[k-lmove] + A[k-lmove];;
			int rtotal = pref[k+rmove] - pref[k];
			result = Math.max(result, ltotal+rtotal);
			lmove -= 1;
		}
		
		return result;
	}
	
	public static void main(String... arg){
		int[] A = {2,3,7,5,1,4,9};
		int k = 4;
		int m = 2;
		System.out.println(solve(A, k, m));
		double d = (2+3)/2.0;
		System.out.println(d);
	}
}
