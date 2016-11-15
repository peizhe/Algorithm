package Leetcode;

public class AddAndSearchWord211 {
	
	class Node {
		Node[] son;
		int count;
		char val;
		boolean isEnd;
		
		Node(){
			son = new Node[26];
			count = 1;
			isEnd = false;
		}
	}
	
	private Node root;
	
	public AddAndSearchWord211(){
		root = new Node();
	}
	
	// Adds a word into the data structure.
    public void addWord(String word) {
    	if(word == null || word.length() == 0){
    		return;
    	}
    	
    	Node node = root;
    	char[] ch = word.toCharArray();
    	int len = ch.length;
    	for(int i = 0;i < len;i ++){
    		int c = ch[i] - 'a';
    		
    		if(node.son[c] == null){
				node.son[c] = new Node();
				node.son[c].val = ch[i];
			} else {
				node.son[c].count ++;
			}
    		
			node = node.son[c];
    	}
    	
    	node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	char[] ch = word.toCharArray();
    	int len = ch.length;
        return searchHelp(root, ch, len, 0);
    }
    
    private boolean searchHelp(Node root, char[] ch, int len, int start) { 	
    	Node node = root;
        
        for(int i = start;i < len;i ++) {
        	char c = ch[i];
        	if(c == '.'){//碰见'.',则做一个深度搜索
        		for(int j = 0;j < 26;j ++){
        			if(node.son[j] != null && searchHelp(node.son[j], ch, len, i + 1)) {
        				return true;
        			}
        		}
        		
        		return false;
        	} else {
        		if(node.son[c - 'a'] == null){
        			return false;
        		}
        		node = node.son[c - 'a'];
        	}
        }
        
        return node.isEnd;
    }
}
