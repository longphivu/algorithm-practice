package gtlt.generation;

public class Permutation {

	
	/**Generate all permutation from input array
	 * @param input char[]
	 */
	public static void generatePermutation(char[] input) {
		int n = input.length;
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		
		printArray(input, arr);
		
		for (int i = n-2; i >= 0; i--) {
			if (arr[i] < arr[i+1]) {
				int swapIdex = i+1;
				int min = arr[swapIdex];
				for (int j = i+1; j < n; j++) {
					if (arr[j] > arr[i]) {
						if (arr[j] < min) {
							swapIdex = j;
							min = arr[j];
						}
					}
				}
				
				swap(arr, i, swapIdex);
				reverse(arr, i+1, n-1);
				i = n-1;
				
				printArray(input, arr);
			}
		}
	}
	
	/** Generate all permutation from 0 to n-1
	 * @param n range of number
	 */
	public static void iterative(int n) {
		int[] arr = new int[n];
		//initialize smallest set
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		printArray(arr);
		//scan from left to right to find the first inverted pair ,e.g a[i] < a[i+1]
		for (int i = n-2; i >= 0; i--) {
			if (arr[i] < arr[i+1]) {
				//find the smallest that larger than a[i] in [i+1, n)
				int swapIdex = i+1;
				int min = arr[swapIdex];
				for (int j = i+1; j < n; j++) {
					if (arr[j] > arr[i]) {
						if (arr[j] < min) {
							swapIdex = j;
							min = arr[j];
						}
					}
				}
				//swap min and a[i]
				swap(arr, i, swapIdex);
				//reverse elements after i
				reverse(arr, i+1, n-1);
				//reset i
				i = n-1;
				//print result
				printArray(arr);
			}
		}
	}
	
	public static void reverse(int[] arr, int from, int to) {
		if (from >= to) return;
		if (from < 0 || to >= arr.length) return;
		while (from < to) {
			swap(arr, from++, to--);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	public static void printArray(int[] arr) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void printArray(char[] source, int[] index) {
		for (int e : index) {
			System.out.print(source[e] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//iterative(4);
		char[] cs = {'a', 'b', 'c', 'd'};
		generatePermutation(cs);
	}

}
