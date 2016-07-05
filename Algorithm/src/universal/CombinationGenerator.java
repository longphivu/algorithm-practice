package universal;

public class CombinationGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"A","B","C","D","S"};
		generate(a, 5, 3);
	}
	
	static void generate(Object[] a, int n, int m){
		
		int[] pos = new int[n];
		for(int i = 0; i < n; i++){
			pos[i] = i;
		}
		int[] b = new int[m];
		b[0] = pos[0];
		fill(b, 1, m-1, 0);
		print(b);
		
		int i = m-1;
		while (i >= 0){
			while (b[i] < pos[n - m + i]){
				b[i]++;
				print(b);
			}
		
			//reset
			fill(b, i+1, i+1, 0);
			i--;
			
			if(i >= 0 && b[i] < pos[n - m + i]){
				b[i] = b[i]+1;
				fill(b, i+1, m-1, 1);
				i = m-1;
			}
		}
		print(b);
		
	}
	
	static void fill(int[] b, int from, int to, int d){
		if( d < 0 || d > 1)
			return;
		for(int i = from; i < b.length && i <= to; i++){
			b[i] = b[i-1]+1;
		}
	}

	static void print(int[] a){
		for(int i : a){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
