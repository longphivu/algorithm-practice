package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 31, 2016
 * Problem:		Q300_LongestIncreasingSubsequence.java
 * Source:		https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Description:	Given an unsorted array of integers, find the length of longest increasing subsequence.
				For example,
				Given [10, 9, 2, 5, 3, 7, 101, 18],
				The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
				Your algorithm should run in O(n2) complexity.
				Follow up: Could you improve it to O(n log n) time complexity? 
 *
 * Solution:	DP, use map to store LIS so far from the left, for each element check how many value that element is greater than
 * Complexity:	O(n^2)
 * Notes:
 *				
 * Follow up:	Could you improve it to O(n log n) time complexity?
 */
public class Q300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        
        int ans = 1;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int key : map.keySet()) {
                if (nums[i] > key) {
                    max = Math.max(map.get(key) + 1, max);
                }
            }
            map.put(nums[i], max);
            ans = Math.max(max, ans);
        }
        
        return ans;
    }
	
	/**
	 * O(nlogn) solution
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        
        int ans = 1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            
            Integer key = map.lowerKey(nums[i]);
            max = key == null ? 1 : Math.max(map.get(key) + 1, max);
            map.put(nums[i], max);
            
            ans = Math.max(max, ans);
        }
        
        return ans;
    }
}
