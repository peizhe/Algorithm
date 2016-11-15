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
 * 队列是一个接口,其继承 Collection 接口:
 * 	其子接口包括：
 * 		BlockingDeque<E>, BlockingQueue<E>, Deque<E>
 * 	直接实现了该接口的类：
 * 		ConcurrentLinkedQueue<E> 
 * 		  
 */
public interface Queue {
	ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<Integer>();
	
	/**
	 * 双向队列Deque
	 * 直接实现该接口类：
	 * 		ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList 
	 */
	public interface Deque {
		//数组实现的双向队列
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		
		//链表实现的双向队列
		LinkedList<Integer> ll = new LinkedList<Integer>();
	}
	
	/**
	 * 阻塞队列BlockingQueue
	 * 直接实现该接口类：
	 * 		ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue
	 */
	public interface BlockingQueue{
		//数组实现的阻塞队列
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		
		//链表实现的阻塞队列
		LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<Integer>();
		
		//优先阻塞队列
		PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>();
		
		//延时队列
		//DelayQueue<放置实现了Delayed接口的元素>
		
		//同步队列
		SynchronousQueue<Integer> sq = new SynchronousQueue<Integer>();
	}
	
	/**
	 * 双向阻塞队列BlockingDeque
	 * 直接实现该接口的类：
	 * 		LinkedBlockingDeque 	
	 */
	public interface BlockingDeque{
		//链表实现的阻塞的双向队列
		LinkedBlockingDeque<Integer> lbd = new LinkedBlockingDeque<Integer>();
	}
}
