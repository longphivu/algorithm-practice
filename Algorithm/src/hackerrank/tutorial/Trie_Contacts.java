package hackerrank.tutorial;

import java.util.Scanner;

/**
 * Author:		Long Vu, longvu.cs@outlook.com
 * Date:		Oct 20, 2016
 * Problem:		Trie_Contacts.java
 * Source:		https://www.hackerrank.com/challenges/ctci-contacts
 *
 * Description:	We're going to make our own Contacts application! The application must perform two types of operations:
				1.add name, where name is a string denoting a contact name. This must store name as a new contact in the application. 
				2.find partial, where partial is a string denoting a partial name to search the application for. It must count the number of contacts starting with partial and print the count on a new line.
				Given  sequential add and find operations, perform each operation in order.

				Sample Input
				4
				add hack
				add hackerrank
				find hac
				find hak
				
				Sample Output
				2
				0
 * Solution:	Use Trie data structure
 * Complexity:	O(m), m: length of the searching word
 * Notes:	
 *				
 * Follow up:	
 */
public class Trie_Contacts {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = new Node();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if ("add".equals(op)) {
				Node.addToTrie(contact, root);
			} else if ("find".equals(op)) {
				int cnt = Node.countTrie(contact, root);
				System.out.println(cnt);
			}
		}
	}
}

class Node {
	Node[] childs;
	int cnt;

	Node() {
		childs = new Node[26];
		cnt = 0;
	}

	public static void addToTrie(String word, Node root) {
		root.cnt++;
		addToTrie(word, 0, root);
	}

	private static void addToTrie(String word, int idx, Node node) {
		if (idx == word.length())
			return;

		char c = word.charAt(idx);
		int pos = c - 'a';
		if (node.childs[pos] == null) {
			node.childs[pos] = new Node();
		}
		node.childs[pos].cnt++;
		addToTrie(word, idx + 1, node.childs[pos]);
	}

	public static int countTrie(String word, Node root) {
		return findTrie(word, 0, root);
	}

	private static int findTrie(String word, int idx, Node node) {
		if (node == null)
			return 0;

		char c = word.charAt(idx);
		int pos = c - 'a';
		// not found
		if (node.childs[pos] == null)
			return 0;
		// reach end of searched word
		if (idx == word.length() - 1)
			return node.childs[pos] == null ? 0 : node.childs[pos].cnt;

		return findTrie(word, idx + 1, node.childs[pos]);
	}
}