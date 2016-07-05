package Colidity.PrefixSum;

public class MinAvgTwoSlice {

	public int solution(int[] A) {
        int n = A.length;
        
        if(n < 2) return 0;
        
        double min = (A[0]+A[1])/2.0;
        int ret = 0;
        for(int i = 2; i<n; i++){
            double avg = (A[i]+A[i-1])/2.0;
            if(avg < min){
                min = avg;
                ret = i-1;
            }
            avg = (A[i]+A[i-1]+A[i-2])/3.0;
            if(avg < min){
                min = avg;
                ret = i-2;
            }
        }
        
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
