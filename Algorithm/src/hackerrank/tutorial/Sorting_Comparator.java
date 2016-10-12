package hackerrank.tutorial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 12, 2016
 * Problem:		Sorting_Comparator.java
 * Source:		https://www.hackerrank.com/challenges/ctci-comparator-sorting
 *
 * Description:	
 *
 * Solution:	
 * Complexity:
 * Notes:
 *				
 * Follow up:	
 */
public class Sorting_Comparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}	
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}

class Checker implements Comparator<Player> {
	public int compare(Player p1, Player p2) {
		if (p1.score != p2.score) {
			return Integer.compare(p2.score, p1.score);
		} else {
			return p1.name.compareTo(p2.name);
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
