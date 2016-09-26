package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 26, 2016
 * Problem:		Q040_CombinationSumII.java
 * Source:		
 *
 * Description:	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
				Each number in C may only be used once in the combination. 
				Note:
				•All numbers (including target) will be positive integers.
				•The solution set must not contain duplicate combinations.
				For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
				 A solution set is: 
				[
				  [1, 7],
				  [1, 2, 5],
				  [2, 6],
				  [1, 1, 6]
				]
 *
 * Solution:	DFS
 * Complexity:	O(!n) ?
 * Notes:
 *				
 * Follow up:	(H) Maximal Rectangle   (M) Wiggle Sort   (H) Find the Duplicate Number  
 */
public class Q040_CombinationSumII {

	public static void main(String[] args) {
		int[] cans = {10, 1, 2, 7, 6, 1, 5} ;
		int tar = 8;
		System.out.println(combinationSum2(cans, tar));

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        dfs(candidates, target, 0, solutions, current);
        
        return solutions;        
    }
    
    
    public static boolean dfs(int[] candidates, int remain, int idx, List<List<Integer>> solutionSet, List<Integer> solution) {
        if (remain < 0) {
            return false;
        }
        
        if (remain == 0) {
            solution = new ArrayList(solution);
            solutionSet.add(solution);
            return false;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i-1])
                continue;
                
            solution.add(candidates[i]);
            boolean isContinue = dfs(candidates, remain-candidates[i], i+1, solutionSet, solution);
            solution.remove(solution.size()-1);
            
            if (!isContinue) break;
        }
        
        return true;
    }
}
