package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ͬ����˼�룬
 * 	��������ô󶥶Ѻ�С���Ѿͻ��ʱ
 * 	ʹ������С���Ѿͻ�ʡʱ
 * 
 * @author MG
 *
 */
public class FindMedianFromDataStream295 {
	
	//��С��һ��
	private Queue<Long> small = new PriorityQueue<Long>();
	//�ϴ��һ��
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
