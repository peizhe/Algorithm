package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 同样的思想，
 * 	但是如果用大顶堆和小顶堆就会耗时
 * 	使用两个小顶堆就会省时
 * 
 * @author MG
 *
 */
public class FindMedianFromDataStream295 {
	
	//较小的一半
	private Queue<Long> small = new PriorityQueue<Long>();
	//较大的一半
	private Queue<Long> large = new PriorityQueue<Long>();

	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek()
				: (large.peek() - small.peek()) / 2.0;
	}
}
