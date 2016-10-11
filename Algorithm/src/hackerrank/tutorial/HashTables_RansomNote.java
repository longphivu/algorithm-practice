package hackerrank.tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 11, 2016
 * Problem:		HashTables_RansomNote.java
 * Source:		https://www.hackerrank.com/challenges/ctci-ransom-note
 *
 * Description:	Given the words in the magazine and the words in the ransom note, 
 * 				print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * Solution:	Hash Map, then count the difference
 * Complexity:	O(n)
 * Notes:
 *				
 * Follow up:	
 */
public class HashTables_RansomNote {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        in.close();
        
        System.out.println(isRansomable(magazine, ransom));
    }
    
    public static String isRansomable(String[] magazine, String[] ransom) {
        Map<String, Integer> mMap = new HashMap<>();
        Map<String, Integer> rMap = new HashMap<>();
        
        Integer one = new Integer(1);
        
        for (String m : magazine) {
            Integer count = mMap.get(m);
            mMap.put(m, count == null ? one : count + 1);
        }
        
        for (String r : ransom) {
        	Integer count = mMap.get(r);
            mMap.put(r, count == null ? one : count + 1);
        }
        
        for (String r : rMap.keySet()) {
            if (!mMap.containsKey(r) || mMap.get(r) < rMap.get(r))
                return "No";
        }
        
        return "Yes";
    }
}
