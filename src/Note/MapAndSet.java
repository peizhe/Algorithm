package Note;

public class MapAndSet {
	/**
	 * Map接口，没有父接口
	 * 
	 * @author MG
	 *
	 * @param <K>
	 * @param <V>
	 */
	public interface Map<K,V>{
		public interface SortedMap<K,V>{
			
			/**
			 * 底层拿红黑树实现
			 * 
			 * @author MG
			 *
			 * @param <K>
			 * @param <V>
			 */
			public class TreeMap<K,V>{}
		}
		
		/**
		 * 散列表解决冲突的方法 :
		 * 	1.链接法(java的HashMap用链接法实现的)
		 * 	2.开放寻址法
		 * 	3.完全散列 
		 * 	4.双重散列
		 * 	5.公共缓冲区
		 * 
		 * 	Entry[] table = new Entry[size];
		 * 		当table中元素个数达到table.length * loadFactor时，需要建立新的table,将旧的table中的元素全部取出来进行散列重新保存到新的table
		 * 	
		 * 计算散列地址的方法 : key类型是Object
		 * 		int h = hash(key.hashCode()) //key.hashCode()是根据内存地址导出的散列码
		 * 		int index = h & (table.length - 1) //table.length 一般是2的幂
		 * 
		 * 		index是最终的散列地址(元素遍历的顺序也是根据这个地址来的)
		 * 
		 * @author MG
		 *
		 * @param <K>
		 * @param <V>
		 */
		public class HashMap<K,V>{
			/**
			 * 它继承于HashMap、底层使用哈希表与双向链表来保存所有元素:
			 * 	1.它保留插入的顺序，如果需要输出的顺序和输入时的相同，那么就选用LinkedHashMap。
			 * 	2.LinkedHashMap维护着一个运行于所有条目的双重链接列表。此链接列表定义了迭代顺序，该迭代顺序可以是插入顺序或者是访问顺序。
			 * 		此实现不是同步的。如果多个线程同时访问链接的哈希映射，而其中至少一个线程从结构上修改了该映射，则它必须保持外部同步。
			 * 	3.默认是按插入顺序排序，如果指定按访问顺序排序，那么调用get方法后，会将这次访问的元素移至链表尾部，不断访问可以形成按访问顺序排序的链表。
			 * 		可以重写removeEldestEntry方法返回true值指定插入元素时移除最老的元素。(这个性质实现LRU非常方便，重写removeEldestEntry()方法)
			 * 
			 * @author MG
			 *
			 * @param <K>
			 * @param <V>
			 */
			@SuppressWarnings("hiding")
			public class LinkedHashMap<K,V>{}
		}
		
		public class HashTable<K,V>{}
	}
	
	/**
	 * set接口，父接口是Collection
	 * 
	 * 	set底层是拿map实现的,所以set的遍历和map的遍历是想通的
	 * 		遍历元素的顺序和元素加入set的顺序是不同的,它和元素散列后的地址的顺序相同
	 *		每次遍历set得到的顺序是相同的,只是和加入set的顺序不同
	 * 
	 * @author MG
	 *
	 * @param <K>
	 */
	public interface Set<K>{
		public interface SortedSet<V>{
			/**
			 * 使用的是TreeMap(底层也是红黑树)
			 * 
			 * @author MG
			 *
			 * @param <V>
			 */
			public class TreeSet<V>{}
		}
		
		public class HashSet<V>{}
	}
}
