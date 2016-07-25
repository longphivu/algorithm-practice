package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q127_WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
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
		Set<String> visited = new HashSet<String>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				beginWord = queue.poll();
				for (String word : wordList) {
					if (charDiff(beginWord, endWord) <= 1) {
						return steps+1;
					} else if (charDiff(beginWord, word) == 1 && !visited.contains(word)) {
						queue.add(word);
						visited.add(word);
					}
				}
				steps++;
			}
		}

		return 0;
	}
	
	public static int charDiff(String s1, String s2){
        if(s1.length() != s2.length()) return 2;
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        return cnt;
    }
}
