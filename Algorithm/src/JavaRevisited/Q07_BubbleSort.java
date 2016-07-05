package JavaRevisited;

public class Q07_BubbleSort {
public static void bubbleSort(int[] arr){
	for(int i = 0; i<arr.length; i++){
		for(int j = 0; j<arr.length; j++){
			if(arr[i]>arr[j]){
				swap (arr, i, j);
			}
		}
	}
}

private static void swap(int[] arr, int i, int j){
	int temp = arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
}


}
