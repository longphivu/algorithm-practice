package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Sep 26, 2016
 * Problem:		Q216_CombinationSumIII.java
 * Source:		https://leetcode.com/problems/combination-sum-iii/
 *
 * Description:	
				Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
				Example 1:
				Input: k = 3, n = 7
				Output: 
				[[1,2,4]]
				Example 2:
				Input: k = 3, n = 9
				Output: 
				[[1,2,6], [1,3,5], [2,3,4]]
				Credits:
				Special thanks to @mithmatt for adding this problem and creating all test cases.
 *
 * Solution:	DFS
 * Complexity:	O(n!) ?
 * Notes:
 *				
 * Follow up:	(M) Combinations   (M) Construct Binary Tree from Preorder and Inorder Traversal   (M) Generalized Abbreviation  
 */
public class Q216_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        dfs(k, n, 1, solutionSet, solution);
        
        return solutionSet;
    }
    
    public static void dfs(int k, int n, int num, List<List<Integer>> solutionSet, List<Integer> solution) {
        if (num < 0 || num > 10 || n < 0) return;
        
        if (n == 0) { //always return when total sum has been reached
            if (solution.size() == k) 
                solutionSet.add(new ArrayList<Integer>(solution));
            return;
        }
        
        if (solution.size() >= k) return; //no need to process if k has been reached
        
        for (int i = num; i <= 9; i++) {
            solution.add(i);
            dfs(k, n-i, i+1, solutionSet, solution);
            solution.remove(solution.size()-1);
        }
    }
}
