package leetcode.array;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Aug 22, 2016
 * Problem:		Q169_MajorityElement.java
 * Source:		https://leetcode.com/problems/majority-element/
 *
 * Description:	Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
				You may assume that the array is non-empty and the majority element always exist in the array.
				Credits:
				Special thanks to @ts for adding this problem and creating all test cases.
 *
 * Solution:	Simple solution: sort 
 * 				Linear solution: think major and non-major as a pair, finally only one major element remain
 * Complexity:	O(logn), O(n)
 * Notes:		http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
 *				
 * Follow up:	(M) Majority Element II
 */
public class Q169_MajorityElement {

    public static int majorityElement(int[] num) {
        int major = num[0];
        int cnt = 1;
        for (int i = 1; i < num.length; i++) {
            if (cnt == 0) {
                major = num[i];
                cnt++;
            } else if (num[i] == major)
                cnt++;
            else 
                cnt--;
        }
        return major;
    }
}
