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
	
	//����
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		return map.get(key);
	}

	//���(��������Ǻ���)
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
	 * ������˳��洢��Map
	 * 	�Լ�ʵ��map,��Ҫ��дremoveEldestEntry
	 * 	removeEldestEntry():
	 * 		Ĭ������·���false : ��ʾ������Զ��Ч��������map��ɾ��
	 * 		�޸ĺ� : ������trueʱ����ʹ������δ���ʵ�Ԫ�ش�map��ɾ��
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
