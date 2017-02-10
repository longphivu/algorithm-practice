package leetcode.array;

import java.util.Arrays;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Feb 9, 2017
 * Problem:		Q475_Heaters.java
 * Source:		https://leetcode.com/problems/heaters/
 *
 * Description:	Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
				Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
				So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters. 
 *
 * Solution:	Sort both input arrays
				Sequentially, find the minimum radius for current house by finding all heater from the left of it and the immediate heater on the right of it
 * Complexity:	max(O(nlogn), O(mlogm))
 * Notes:		
 *				
 * Follow up:	(M) Binary Tree Longest Consecutive Sequence  
 */
public class Q475_Heaters {
	public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0 || heaters.length == 0) return 0;
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int minRadius = Integer.MIN_VALUE;
            
        int j = 0;
        int preHeater = j;
        for (int i = 0; i < houses.length; i++) {
            int needRadius = Math.abs(houses[i] - heaters[preHeater]);
            //find min radius for heaters that lies on the left of the house, heater's position <= house's position
            while (j < heaters.length && houses[i] >= heaters[j]) {
                needRadius = Math.min(needRadius, houses[i] - heaters[j]);
                preHeater = j;
                j++;
            }
            //compare with the radius of the first heater lies on the right of the house, heater's position > house's position
            if (j < heaters.length)
                needRadius = Math.min(needRadius, heaters[j] - houses[i]);
            
            //update minRadius;
            minRadius = Math.max(minRadius, needRadius);
        }
        
        return minRadius;
    }
}
