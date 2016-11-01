package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 1, 2016
 * Problem:		Q015_3Sum.java
 * Source:		https://leetcode.com/problems/3sum/
 *
 * Description:	
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Q015_3Sum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (num.length < 3)
			return result;

		// sort array
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || num[i] > num[i - 1]) {

				int negate = -num[i];

				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					// case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);

						result.add(temp);
						start++;
						end--;
						// avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;

						while (start < end && num[start] == num[start - 1])
							start++;
						// case 2
					} else if (num[start] + num[end] < negate) {
						start++;
						// case 3
					} else {
						end--;
					}
				}

			}
		}

		return result;
	}
}
