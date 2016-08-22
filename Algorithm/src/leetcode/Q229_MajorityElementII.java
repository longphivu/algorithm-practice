package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 22, 2016
 * Problem:		Q229_MajorityElementII.java
 * Source:		https://leetcode.com/problems/majority-element-ii/
 *
 * Description:	Given an integer array of size n, find all elements that appear more than n/3 times. 
 * 				The algorithm should run in linear time and in O(1) space.
 *
 * Solution:	
 * Complexity:	O(n) time, O(1) space
 * Notes:		
 *				
 * Follow up:	(M) Rotate Image   (M) Word Search   (M) Shortest Word Distance III  
 */
public class Q229_MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        long m1 = Long.MAX_VALUE;
        long m2 = Long.MAX_VALUE;
        int c1 = 0, c2 = 0;
        
        for (int n : nums) {
            if (m1 != Long.MAX_VALUE && m1 == n) {
                c1++;
            } else if (m2 != Long.MAX_VALUE && m2 == n) {
                c2++;
            } else if (c1 == 0) {
                m1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = c2 = 0;
        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if(n == m2) {
                c2++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        if (c1 > nums.length/3) 
            result.add(new Integer((int) m1));
        if (c2 > nums.length/3)
            result.add(new Integer((int) m2));
        return result;
    }
}
