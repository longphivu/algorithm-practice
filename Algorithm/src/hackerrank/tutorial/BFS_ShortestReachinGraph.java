package hackerrank.tutorial;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BFS_ShortestReachinGraph {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			Node[] nodes = new Node[n + 1];
			while (n > 0) {
				nodes[n] = new Node(n);
				n--;
			}
			while (m-- > 0) {
				int from = in.nextInt();
				int to = in.nextInt();
				nodes[from].edges.add(to);
				nodes[to].edges.add(from);
			}
			int start = in.nextInt();
			System.out.println(solve(nodes, start));
		}
		in.close();
	}

	public static String solve(Node[] nodes, int start) {
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[nodes.length + 1];
		int[] path = new int[nodes.length + 1];

		Queue<Node> queue = new LinkedList<>();
		queue.add(nodes[start]);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Node cur = queue.poll();
				if (!visited[cur.id]) {
					visited[cur.id] = true;
					path[cur.id] = level;
					for (int next : cur.edges) {
						if (!visited[next]) {
							queue.add(nodes[next]);
						}
					}
				}
			}
			level++;
		}
		for (int i = 1; i < nodes.length; i++) {
			if (i != start) {
				sb.append(path[i] == 0 ? -1 : path[i] * 6).append(" ");
			}
		}
		return sb.toString();
	}
}

class Node {
	int id;
	Set<Integer> edges;

	Node(int id) {
		this.id = id;
		edges = new HashSet<>();
	}
}