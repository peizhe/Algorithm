package Leetcode;

/**
 * 构建一棵字典树：
 * 	永远是站在上一个节点观看下一个节点
 * @author MG
 *
 */
public class ImplementTrie208 {
	
    private TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if(word == null || word.trim().length() == 0){
    		return;
    	}
        char[] ch = word.toCharArray();
        int len = ch.length;
        TrieNode node = root;
        for(int i = 0;i < len;i ++){
        	int c = ch[i] - 'a';
        	if(node.son[c] == null){
        		node.son[c] = new TrieNode();
        		node.son[c].val = ch[i];
        	} else {
        		node.son[c].count ++;
        	}
        	
        	node = node.son[c];
        }
        
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if(word == null || word.trim().length() == 0){
    		return false;
    	}
    	
        char[] ch = word.toCharArray();
        int len = ch.length;
        TrieNode node = root;
        for(int i = 0;i < len;i ++){
        	int c = ch[i] - 'a';
        	if(node.son[c] == null) {
        		return false;
        	}
        	
        	node = node.son[c];
        }
        
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	
    	if(prefix == null || prefix.trim().length() == 0){
    		return false;
    	}
    	
    	char[] ch = prefix.toCharArray();
        int len = ch.length;
        TrieNode node = root;
        for(int i = 0;i < len;i ++){
        	int c = ch[i] - 'a';
        	if(node.son[c] == null) {
        		return false;
        	}
        	node = node.son[c];
        }
        
        return true;
    }
}

class TrieNode {
	
	TrieNode[] son;
	int count;
	char val;
	boolean isEnd;
	
    // Initialize your data structure here.
    public TrieNode() {
        son = new TrieNode[26];
        count = 1;
        isEnd = false;
    }
}
