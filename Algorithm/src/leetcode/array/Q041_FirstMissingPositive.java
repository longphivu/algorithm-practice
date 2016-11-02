package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q041_FirstMissingPositive.java
 * Source:		https://leetcode.com/problems/first-missing-positive/
 *
 * Description:	Given an unsorted integer array, find the first missing positive integer.
				For example,
				Given [1,2,0] return 3,
				and [3,4,-1,1] return 2.
				Your algorithm should run in O(n) time and uses constant space. 
 *
 * Solution:	Use additional space to store the number appearance
 * Complexity:	O(n)
 * Notes:		Constant space solution: swap number to their respective position, if outside range leave it
 *				
 * Follow up:	
 */
public class Q041_FirstMissingPositive {
	public int firstMissingPositive(int[] A) {

		int n = A.length;
		boolean[] track = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			int cur = A[i];
			if (cur > 0 && cur <= n) {
				track[cur] = true;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (track[i] == false)
				return i;
		}
		return n + 1;
	}
	
	public static int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        int last = nums.length-1;
        for (int i = 0; i < nums.length && last >= 0; i++) {
            int cur = nums[i];
            //ignore these case:
            //1. outside range
            //2. already at correct position: cur == i+1
            //3. another number already there: nums[cur-1] == cur ,eg. [1,1]
            while (cur > 0 && cur <= nums.length && cur != i+1 && nums[cur-1] != cur) {
                swap(nums, i, cur-1);
                cur = nums[i];
            }
        }
        
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                result = i+1;
                break;
            }
        }
        
        return result == 0 ? nums.length+1 : result;
    }
    
    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
    
    public static void main(String...stri) {
    	int[] arr = {3,0,1,1};
    	System.out.println(firstMissingPositive2(arr));
    }
}
