package Note;

public class MapAndSet {
	/**
	 * Map�ӿڣ�û�и��ӿ�
	 * 
	 * @author MG
	 *
	 * @param <K>
	 * @param <V>
	 */
	public interface Map<K,V>{
		public interface SortedMap<K,V>{
			
			/**
			 * �ײ��ú����ʵ��
			 * 
			 * @author MG
			 *
			 * @param <K>
			 * @param <V>
			 */
			public class TreeMap<K,V>{}
		}
		
		/**
		 * ɢ�б�����ͻ�ķ��� :
		 * 	1.���ӷ�(java��HashMap�����ӷ�ʵ�ֵ�)
		 * 	2.����Ѱַ��
		 * 	3.��ȫɢ�� 
		 * 	4.˫��ɢ��
		 * 	5.����������
		 * 
		 * 	Entry[] table = new Entry[size];
		 * 		��table��Ԫ�ظ����ﵽtable.length * loadFactorʱ����Ҫ�����µ�table,���ɵ�table�е�Ԫ��ȫ��ȡ��������ɢ�����±��浽�µ�table
		 * 	
		 * ����ɢ�е�ַ�ķ��� : key������Object
		 * 		int h = hash(key.hashCode()) //key.hashCode()�Ǹ����ڴ��ַ������ɢ����
		 * 		int index = h & (table.length - 1) //table.length һ����2����
		 * 
		 * 		index�����յ�ɢ�е�ַ(Ԫ�ر�����˳��Ҳ�Ǹ��������ַ����)
		 * 
		 * @author MG
		 *
		 * @param <K>
		 * @param <V>
		 */
		public class HashMap<K,V>{
			/**
			 * ���̳���HashMap���ײ�ʹ�ù�ϣ����˫����������������Ԫ��:
			 * 	1.�����������˳�������Ҫ�����˳�������ʱ����ͬ����ô��ѡ��LinkedHashMap��
			 * 	2.LinkedHashMapά����һ��������������Ŀ��˫�������б��������б����˵���˳�򣬸õ���˳������ǲ���˳������Ƿ���˳��
			 * 		��ʵ�ֲ���ͬ���ġ��������߳�ͬʱ�������ӵĹ�ϣӳ�䣬����������һ���̴߳ӽṹ���޸��˸�ӳ�䣬�������뱣���ⲿͬ����
			 * 	3.Ĭ���ǰ�����˳���������ָ��������˳��������ô����get�����󣬻Ὣ��η��ʵ�Ԫ����������β�������Ϸ��ʿ����γɰ�����˳�����������
			 * 		������дremoveEldestEntry��������trueֵָ������Ԫ��ʱ�Ƴ����ϵ�Ԫ�ء�(�������ʵ��LRU�ǳ����㣬��дremoveEldestEntry()����)
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
	 * set�ӿڣ����ӿ���Collection
	 * 
	 * 	set�ײ�����mapʵ�ֵ�,����set�ı�����map�ı�������ͨ��
	 * 		����Ԫ�ص�˳���Ԫ�ؼ���set��˳���ǲ�ͬ��,����Ԫ��ɢ�к�ĵ�ַ��˳����ͬ
	 *		ÿ�α���set�õ���˳������ͬ��,ֻ�Ǻͼ���set��˳��ͬ
	 * 
	 * @author MG
	 *
	 * @param <K>
	 */
	public interface Set<K>{
		public interface SortedSet<V>{
			/**
			 * ʹ�õ���TreeMap(�ײ�Ҳ�Ǻ����)
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
