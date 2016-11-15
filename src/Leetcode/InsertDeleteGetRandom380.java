package Leetcode;

import java.util.Random;

/**
 * ���һ�����ݽṹҪ��:
 * 	1.����һ��Ԫ�أ����벻����Ԫ�ط��� True�����򷵻� False(O(1))
 * 	2.�Ƴ�һ��Ԫ�أ�set�д��ڸ�Ԫ���򷵻� True�����򷵻� False(O(1))
 * 	3.����õ�һ��Ԫ��,Ҫ��ʱ����O(1)
 * @author MG
 *
 */
public class InsertDeleteGetRandom380 {	
	private Random random;
	private Node root;
	private int countNode;
	
	public class Node{
		Node[] next;
		int count;
		
		public Node(){
			next = new Node[2];
			count = 0;
		}
	}
	
	/** Initialize your data structure here. */
    public InsertDeleteGetRandom380() {
    	root = new Node();
    	random = new Random();
    	countNode = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        Node temp = root;
        int bit, flag;
        for(int i = 31;i >= 0;i --){
        	bit = val & (1 << i); 
        	flag = bit == 0 ? 0 : 1;
        	
        	if(temp.next[flag] == null){
        		temp.next[flag] = new Node();
        		res = true;
        	}
        	
        	temp = temp.next[flag];
        }
    	
        temp = root;
        if(res){
        	for(int i = 31;i >= 0;i --){
            	bit = val & (1 << i); 
            	flag = bit == 0 ? 0 : 1;
            	
            	temp.next[flag].count ++;
            	
            	temp = temp.next[flag];
            }
        	
        	countNode ++;
        }
        
    	return res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(countNode == 0){
    		return false;
    	}
    	
    	boolean res = true;
    	Node temp = root;
    	int bit, flag;
    	for(int i = 31;i >= 0;i --){
    		bit = val & (1 << i);
    		flag = bit == 0 ? 0 : 1;
    		
    		if(temp.next[flag] == null){
    			res = false;
    			break;
    		}
    		
    		temp = temp.next[flag];
    	}
    	
    	temp = root;
    	if(res){
    		for(int i = 31;i >= 0;i --){
    			bit = val & (1 << i);
    			flag = bit == 0 ? 0 : 1;
    			
    			if(temp.next[flag].count <= 1){
    				temp.next[flag] = null;
    				break;
    			} 
    			
    			temp.next[flag].count --;
    			temp = temp.next[flag];
    		}
    		
    		countNode --;
    	}
    	
    	return res;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	if(countNode == 0){
    		return -1;
    	}
    	Node temp = root;
    	int res = 0;
    	for(int i = 31;i >= 0;i --){
    		int selection = random.nextInt(2);
    		if(temp.next[selection] != null) {
    			res += selection << i;
    			temp = temp.next[selection];
    		} else {
    			res += (1 - selection) << i;
    			temp = temp.next[1 - selection];
    		}
    	}
    	
    	return res;
    }
}
