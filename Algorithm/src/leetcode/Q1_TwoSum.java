package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(nums[i])) {
				ret[0] = map.get(nums[i]);
				ret[1] = i;
				break;
			} else {
				map.put(complement, i);
			}
		}

		return ret;
	}
}
