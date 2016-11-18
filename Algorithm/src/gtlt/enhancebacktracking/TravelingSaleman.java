package gtlt.enhancebacktracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Nov 18, 2016
 * Problem:		TravelingSaleman.java
 * Source:		
 *
 * Description:	
 *
 * Solution:	Backtracking technique, travel all possible route but whenever the current route distance is greater than current min, 
 * 				stop and try another route
 * Complexity:	O(n!)
 * Notes:
 *				
 * Follow up:	
 */
public class TravelingSaleman {

	public static int solve(Map<Integer, Vertex> map) {
		int[] min = new int[1];
		min[0] = Integer.MAX_VALUE;
		
		Set<Integer> visited = new HashSet<>();
		travel(map, 1, 0, visited, min); //we start at 1
		
		return min[0];
	}
	
	private static void travel(Map<Integer, Vertex> map, int start, int distance, Set<Integer> visited, int[] min) {
		if (distance > min[0]) //if current route is greater than current minimum -> stop
			return;
		
		Vertex current = map.get(start);
		
		visited.add(start);
		
		//travel to all node, try go go back to first node
		if (visited.size() == map.size()) { 
			distance += current.edges.get(1);
			min[0] = Math.min(min[0], distance);
			visited.remove(start);//backtrack
			return;
		}
		
		for (int next : current.edges.keySet()) {
			if (!visited.contains(next))
				travel(map, next, distance + current.edges.get(next), visited, min);
		}
		
		visited.remove(start);//backtrack
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		
		Map<Integer, Vertex> map = new HashMap<>();
		while (n-- > 0) {
			int from = in.nextInt();
			int to   = in.nextInt();
			int d    = in.nextInt();
			
			Vertex vertex1 = map.getOrDefault(from, new Vertex(from));
			vertex1.addEdge(to, d);
			Vertex vertex2 = map.getOrDefault(to, new Vertex(to));
			vertex2.addEdge(from, d);
			
			map.put(from, vertex1);
			map.put(to,   vertex2);
		}
		
		in.close();
		
		System.out.println(solve(map));
	}

}

class Vertex {
	int id;
	Map<Integer,Integer> edges;
	
	public Vertex(int id) {
		this.id = id;
		this.edges = new HashMap<>();
	}
	
	public void addEdge(int id, int distance) {
		edges.put(id, distance);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
