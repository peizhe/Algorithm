package Algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode-146
 * 
 * @author MG
 *
 */
public class LRUCode {
	MyMap<Integer, Integer> map;

	public LRUCode(int capacity) {
		map = new MyMap<Integer, Integer>(capacity);
	}
	
	//访问
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		return map.get(key);
	}

	//添加(这个函数是核心)
	public void set(int key, int value) {
		map.put(key, value);
	}
	
	public static void main(String[] mh){
		LRUCode lru = new LRUCode(2);
		lru.set(2, 1);
		lru.set(2, 2);
		System.out.println(lru.get(2));
		lru.set(1, 1);
		lru.set(4, 1);
		System.out.println(lru.get(2));
	}
	
	/**
	 * 按访问顺序存储的Map
	 * 	自己实现map,需要重写removeEldestEntry
	 * 	removeEldestEntry():
	 * 		默认情况下返回false : 表示数据永远有效，不会在map中删除
	 * 		修改后 : 当返回true时，将使最近最久未访问的元素从map中删除
	 * 
	 * @author MG
	 *
	 * @param <K>
	 * @param <V>
	 */
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
}
