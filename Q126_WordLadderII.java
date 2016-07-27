package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Jul 27, 2016
 * Problem:		Q126_WordLadderII.java
 * Source:		https://leetcode.com/problems/word-ladder-ii/
 *
 * Description:	Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that: 
				1.Only one letter can be changed at a time
				2.Each intermediate word must exist in the word list
				
				For example, 
				Given:
				beginWord = "hit"
				endWord = "cog"
				wordList = ["hot","dot","dog","lot","log"]
				
				Return
				  [
				    ["hit","hot","dot","dog","cog"],
				    ["hit","hot","lot","log","cog"]
				  ]
 *
 * Solution:	Same as Q127 Word Ladder, but add a class to keep track of previous word
 * Complexity:	O(n*m*26)
 * Notes:		- one word can be use in multiple solutions
 * 				- https://discuss.leetcode.com/topic/28774/my-30ms-bidirectional-bfs-and-dfs-based-java-solution/2
 *				
 * Follow up:	(M) Palindrome Partitioning   (M) Add and Search Word - Data structure design   (E) Flip Game  
 */
public class Q126_WordLadderII {
	public static void main (String[] agr){
		String begin = "red";
		String end = "tax";
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
		System.out.println(findLadders(begin, end, set));
	}
	
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> solutions = new ArrayList<List<String>>();

		WordNode beginNode = new WordNode(beginWord);
		Queue<WordNode> queue = new LinkedList<WordNode>();
		queue.add(beginNode);

		Set<String> visited = new HashSet<String>();
		int len = 1;
		boolean hasSolution = false;
		while (!queue.isEmpty() && !hasSolution) {
			// start process all node of current level
			int size = queue.size();
			while (size-- > 0) {
				WordNode wnode = queue.poll();
				for (int i = 0; i < wnode.val.length(); i++) {
					char[] chars = wnode.val.toCharArray();
					char temp = chars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;
						String newWord = new String(chars);
						if (newWord.equals(endWord)) {
							ArrayList<String> sol = new ArrayList<String>();
							sol.add(0, endWord);
							WordNode preNode = wnode;
							while (preNode != null) {
								sol.add(0, preNode.val);
								preNode = preNode.pre;
							}
							solutions.add(sol);
							hasSolution = true;
						} else if (wordList.contains(newWord)) {
							visited.add(newWord);
							WordNode newNode = new WordNode(newWord);
							newNode.pre = wnode;
							queue.add(newNode);
						}
					}
					chars[i] = temp; //reset word
				}
			}
			wordList.removeAll(visited); //only remove after finish one level --> one word can be use in multiple solutions
			visited = new HashSet<String>(); //reset
			len++;// move to next level
		}

		return solutions;
	}
}

class WordNode {
	String val;
	WordNode pre;

	WordNode(String val) {
		this.val = val;
	}
	
	public String toString(){
		return val;
	}
}
