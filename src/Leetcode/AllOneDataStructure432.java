package Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOneDataStructure432 {

	class Node {
		String key;
		int val;
		
		public Node(String key,int val){
			this.key = key;
			this.val = val;
		}
	}
	
	Map<String, Node> map;
	PriorityQueue<Node> min;
	PriorityQueue<Node> max;

	/** Initialize your data structure here. */
	public AllOneDataStructure432() {
		map = new HashMap<String, Node>();
		min = new PriorityQueue<Node>(11,new Comparator<Node>() {

			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		
		max = new PriorityQueue<Node>(11,new Comparator<Node>() {

			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.val - o1.val;
			}
		});
	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		if (map.containsKey(key)) {
			Node temp = remove(key);			
			addNewKey(key, temp.val + 1);
			
		} else {
			addNewKey(key, 1);
		}
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		if (map.containsKey(key)) {
			Node temp = remove(key);
			if (temp.val == 1) {
				map.remove(key);
			} else {
				addNewKey(key, temp.val - 1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return max.peek() == null ? "" : max.peek().key;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return min.peek() == null ? "" : min.peek().key;
	}
	
	/**
	 * map以及优先队列中全部添加
	 * 
	 * @param key
	 * @param val
	 */
	private void addNewKey(String key, int val){
		Node temp = new Node(key,val);
		map.put(key, temp);
		
		min.offer(temp);
		max.offer(temp);
	}
	
	/**
	 * 只是将优先队列中的Node删除掉，map中并没有删除
	 * @param key
	 * @return
	 */
	private Node remove(String key){
		Node temp = map.get(key);
		
		min.remove(temp);
		max.remove(temp);
		
		return temp;
	}
}
