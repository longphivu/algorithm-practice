package leetcode;

public class Q208_ImplementTriePrefixTree {

	public static void main(String[] args) {
		 Trie trie = new Trie();
		 trie.insert("a");
		 trie.insert("ab");
		 ;
		 System.out.print(trie.startsWith("a"));
		 System.out.print(trie.search("ab"));
	}

}

class TrieNode {
    TrieNode[] childs;
    boolean isWord;
    // Initialize your data structure here.
    public TrieNode() {
        childs = new TrieNode[26];
        isWord = false;
    }
    
    public void addToTrie(TrieNode root, String word) {
        addHelper(root, word, 0);
    }
    
    private void addHelper(TrieNode node, String word, int idx) {
        if (idx >= word.length()) { //finish a word
            node.isWord = true;
            return;
        }
        
        int pos = word.charAt(idx) - 'a';
        if (node.childs[pos] == null) {
        	node.childs[pos] = new TrieNode();
        }
        
        addHelper(node.childs[pos], word, idx + 1);
    }
    
    public boolean searchTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            TrieNode child = root.childs[pos];
            
            if (child == null) return false;
            
            root = child;
        }
        return root.isWord;
    }
    
    public boolean isStartWith(TrieNode root, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            TrieNode child = root.childs[pos];
            
            if (child == null) return false;
            
            root = child;
        }
        return true;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.addToTrie(root, word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.searchTrie(root, word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.isStartWith(root, prefix);
    }
}