package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 13, 2016
 * Problem:		Qqe.java
 * Source:		
 *
 * Description:	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
				The same repeated number may be chosen from C unlimited number of times. 
				Note:
				•All numbers (including target) will be positive integers.
				•The solution set must not contain duplicate combinations.
				For example, given candidate set [2, 3, 6, 7] and target 7, 
				 A solution set is: 
				[
				  [7],
				  [2, 2, 3]
				]
 *
 * Solution:	DFS
 * Complexity:	O(n!) ?
 * Notes:
 *				
 * Follow up:	(M) Combination Sum II   (M) Combinations   (M) Combination Sum III   (M) Factor Combinations   (M) Combination Sum IV  
 */
public class Q039_CombinationSum {

	public static void main(String[] args) {
		int[] cans = {2, 3, 6, 7} ;
		int tar = 10;
		System.out.println(combinationSum(cans, tar));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        Arrays.sort(candidates);
        
        dfs(candidates, 0, target, solution, solutionSet);
        
        return solutionSet;
    }
    
    private static void dfs(int[] candidates, int i, int remain, List<Integer> solution, List<List<Integer>> solutionSet) {
        if (remain < 0) return;
        
        if (remain == 0) {
            solution = new ArrayList(solution);
            solutionSet.add(solution);
            return;
        }
        
        while (i < candidates.length && remain >= 0) {
            if (remain - candidates[i] >= 0) {
                solution.add(candidates[i]);
                dfs(candidates, i, remain - candidates[i], solution, solutionSet);
                solution.remove(solution.size()-1);
            }
            i++;
        }
    }
}
