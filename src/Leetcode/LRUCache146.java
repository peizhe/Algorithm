package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146<K> {
	MyMap<Integer, Integer> map;

	public LRUCache146(int capacity) {
		map = new MyMap<Integer, Integer>(capacity);
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		return map.get(key);
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

	private static class MyMap<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {
		
		private static final long serialVersionUID = 1L;
		
		private int capacity;

		public MyMap(int capacity) {
			super(capacity, 0.75f, true);
			this.capacity = capacity;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > capacity;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
}
