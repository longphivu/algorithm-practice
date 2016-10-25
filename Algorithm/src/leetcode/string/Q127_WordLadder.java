package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Author:      Long Vu, longvu.cs@outlook.com
 * Date:		Jul 25, 2016
 * Problem:		Q127_WordLadder.java
 * Source:		https://leetcode.com/problems/word-ladder/
 *
 * Description:	Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that: 
				1.Only one letter can be changed at a time
				2.Each intermediate word must exist in the word list
				For example, 
				Given:
				beginWord = "hit"
				endWord = "cog"
				wordList = ["hot","dot","dog","lot","log"]
				As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
				return its length 5. 
 *
 * Solution:	BFS ensure to get the optimize solution
 * Complexity:	O(n*m*26)
 * Notes:		Two-end BFS https://discuss.leetcode.com/topic/29303/two-end-bfs-in-java-31ms
 *				
 * Follow up:	(M) Combination Sum   (M) Linked List Cycle II   (H) Rearrange String k Distance Apart
 */
public class Q127_WordLadder {

	public static void main(String[] args) {
		String begin = "htt";
		String end = "cog";
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(ladderLength(begin, end, set));
	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord == endWord)
			return 0;

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);

		int steps = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				beginWord = queue.poll();
				char[] chrs = beginWord.toCharArray();
				for (int i = 0; i < chrs.length; i++) {
					char temp = chrs[i];
					for (char c = 'a'; c <= 'z'; c++) {
						chrs[i] = c;

						String newWord = new String(chrs);
						if (newWord.equals(endWord))
							return steps + 1;
						if (wordList.contains(newWord)) {
							queue.add(newWord);
							wordList.remove(newWord);
						}
					}
					chrs[i] = temp;
				}
			}
			steps++;
		}

		return 0;
	}

}
