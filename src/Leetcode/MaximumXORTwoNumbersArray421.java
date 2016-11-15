package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORTwoNumbersArray421 {
	
	/**
	 * 更快的方式
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaximumXORBetter(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<Integer>();
            for(int num : nums){
                set.add(num & mask);
            }
            
            int tmp = max | (1 << i);
            
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        
        return max;
    }
	
	/**
	 * 采用Trie树的方式
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length < 2){
        	return 0;
        }
        Node root = new Node();
        
        for(int i : nums){
        	buildTrie(root, i);
        }
        
        int res = Integer.MIN_VALUE;
        for(int i : nums){
        	int temp = findMostMatch(root, i);
        	res = temp > res ? temp : res;
        }
        
        return res;
    }
	
	private int findMostMatch(Node root, int x){
		int res = 0;
		Node temp = root;
		for(int i = 30;i >= 0;i --){
			int bit = x & (1 << i);
			int flag = bit == 0 ? 0 : 1;
			//每次都找与bit相反的分支(相反的不存在才寻找相同的)
			if(temp.next[1 - flag] == null){
				temp = temp.next[flag];
				res += flag << i;
			} else {
				temp = temp.next[1 - flag];
				res += (1 - flag) << i;
			}
		}
		
		return res ^ x;
	}
	
	private void buildTrie(Node root, int x){
		Node temp = root;
		for(int i = 30;i >= 0;i --){
			int bit = x & (1 << i);
			int flag = bit == 0 ? 0 : 1;
			
			if(temp.next[flag] == null){
				temp.next[flag] = new Node();
			}
			
			temp = temp.next[flag];
		}
	}
	
	private static class Node {
		Node[] next;
		
		public Node(){
			next = new Node[2];
		}
	}
}
