package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 25, 2016
 * Problem:		Q381_InsertDeleteGetRandom_DuplicateAllow.java
 * Source:		https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 *
 * Description:	Design a data structure that supports all following operations in average O(1) time.
 *
 * Solution:	Use 2 maps, one to map val and its size, one to map size and it value to get O(1) random
 * Complexity:	O(n) in average
 * Notes:		Need to update val size list after remove
 *				
 * Follow up:	
 */
public class Q381_InsertDeleteGetRandom_DuplicateAllow {

	public static void main(String[] args) {
			 RandomizedCollection obj = new RandomizedCollection();
			 obj.insert(1);
			 obj.remove(1);
			 obj.insert(1);
			 obj.getRandom();
			 obj.getRandom();
	}

}
class RandomizedCollection {

    // store the val and its corresponding size
    Map<Integer, Set<Integer>> valMap;
    // store the size and its corresponding val
    Map<Integer, Integer> sizeMap;
    Random r;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        valMap = new HashMap<>();
        sizeMap = new HashMap<>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int newSize = sizeMap.size() + 1;
        sizeMap.put(newSize, val);
        
        if (valMap.containsKey(val)) {
            valMap.get(val).add(newSize);
            return false;
        } else {
            Set<Integer> sizeSet = new HashSet<>();
            sizeSet.add(newSize);
            valMap.put(val, sizeSet);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valMap.containsKey(val)) {
            return false;
        }
        
        //get the size of the removed val
        Set<Integer> sizeSet = valMap.get(val);
        int toRemove = sizeSet.iterator().next();
        //remove first size
        sizeSet.remove(toRemove);
        
        if (sizeSet.size() == 0) {
            valMap.remove(val);
        }
        
        if (toRemove == sizeMap.size()){
        	sizeMap.remove(toRemove);
        	return true;
        }
        
        //remove from size map, fill the gap with current size
        int size = sizeMap.size();
        int moveVal = sizeMap.get(size);
        sizeMap.put(toRemove, moveVal); //replace with current size's val
        sizeMap.remove(size);
        
        // update the size set of the moved val
        Set<Integer> set = valMap.get(moveVal);
        set.remove(size);
        set.add(toRemove);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	if (valMap.size() == 0) return -1;
        int n = r.nextInt(sizeMap.size()) + 1; //random value from (0,n]
        return sizeMap.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */