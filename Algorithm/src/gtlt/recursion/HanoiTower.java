package gtlt.recursion;

import java.util.Arrays;
import java.util.Stack;

public class HanoiTower {
	
	
	public static void solve(int n, Tower source, Tower buffer, Tower destination) {
		if (n == 1) {
			destination.disks.push(source.disks.pop());
		} else {
			solve(n-1, source, destination, buffer);
			solve(1, source, buffer, destination);
			solve(n-1, buffer, source, destination);
		}
		
	}
	
	public static void main(String... strings) {
		Tower t1 = new Tower();
		Tower t2 = new Tower();
		Tower t3 = new Tower();
		t1.disks.addAll(Arrays.asList(4,3,2,1,0));
		
		System.out.println(t1);
		
		solve(5, t1, t2, t3);
		
		System.out.println(t3);
	}
}

class Tower {
	Stack<Integer> disks = new Stack<>();
	public String toString() {
		return disks.toString();
	}
}
