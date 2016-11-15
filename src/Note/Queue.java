package Note;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * ������һ���ӿ�,��̳� Collection �ӿ�:
 * 	���ӽӿڰ�����
 * 		BlockingDeque<E>, BlockingQueue<E>, Deque<E>
 * 	ֱ��ʵ���˸ýӿڵ��ࣺ
 * 		ConcurrentLinkedQueue<E> 
 * 		  
 */
public interface Queue {
	ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<Integer>();
	
	/**
	 * ˫�����Deque
	 * ֱ��ʵ�ָýӿ��ࣺ
	 * 		ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList 
	 */
	public interface Deque {
		//����ʵ�ֵ�˫�����
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		
		//����ʵ�ֵ�˫�����
		LinkedList<Integer> ll = new LinkedList<Integer>();
	}
	
	/**
	 * ��������BlockingQueue
	 * ֱ��ʵ�ָýӿ��ࣺ
	 * 		ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue
	 */
	public interface BlockingQueue{
		//����ʵ�ֵ���������
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		
		//����ʵ�ֵ���������
		LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<Integer>();
		
		//������������
		PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>();
		
		//��ʱ����
		//DelayQueue<����ʵ����Delayed�ӿڵ�Ԫ��>
		
		//ͬ������
		SynchronousQueue<Integer> sq = new SynchronousQueue<Integer>();
	}
	
	/**
	 * ˫����������BlockingDeque
	 * ֱ��ʵ�ָýӿڵ��ࣺ
	 * 		LinkedBlockingDeque 	
	 */
	public interface BlockingDeque{
		//����ʵ�ֵ�������˫�����
		LinkedBlockingDeque<Integer> lbd = new LinkedBlockingDeque<Integer>();
	}
}
