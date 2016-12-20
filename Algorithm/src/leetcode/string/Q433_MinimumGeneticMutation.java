package leetcode.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Dec 20, 2016
 * Problem:		Q422_MinimumGeneticMutation.java
 * Source:		https://leetcode.com/problems/minimum-genetic-mutation/
 *
 * Description:	A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
				Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
				For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
				Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
				Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
				Note:
				    Starting point is assumed to be valid, so it might not be included in the bank.
				    If multiple mutations are needed, all mutations during in the sequence must be valid.
				    You may assume start and end string is not the same.
 *
 * Solution:	BFS
 * Complexity:	O(8*4*k) (8 character long string, 4 type of nucleotides, k number of mutation steps
 * Notes:
 *				
 * Follow up:	
 */
public class Q433_MinimumGeneticMutation {
	public class Solution {
	    public int minMutation(String start, String end, String[] bank) {
	        Set<String> set = new HashSet<>();
	        for (String s : bank) {
	            set.add(s);            
	        }
	        
	        Queue<String> queue = new LinkedList<>();//use DFS to check mutation step
	        queue.add(start);
	        
	        int noOfMutation = 0;
	        char[] genes = {'A','C','G','T'};
	        Set<String> visited = new HashSet<>();
	        visited.add(start);
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            while (size-- > 0) {
	                char[] geneChars = queue.poll().toCharArray();
	                
	                for (int i = 0; i < geneChars.length; i++) {
	                    char g = geneChars[i]; //current gene
	                    for (int j = 0; j < genes.length; j++) {
	                        if (genes[j] == g) continue;//skip the current gene
	                        
	                        geneChars[i] = genes[j];
	                        String newGene = new String(geneChars);
	                        
	                        if (!set.contains(newGene)) continue;
	                        
	                        if (newGene.equals(end)) return noOfMutation+1;//stop when found the end gene
	                        
	                        if (!visited.contains(newGene)) {
	                            queue.add(newGene);
	                            visited.add(newGene);
	                        }
	                    }
	                    geneChars[i] = g;//reset
	                }
	            }
	            noOfMutation++;// increase mutation 
	        }
	        
	        return -1;//reach here mean no solution
	    }
	}
}
