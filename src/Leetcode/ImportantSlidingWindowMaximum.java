package Leetcode;

import java.util.LinkedList;

/**
 * ˫�����
 * ������˫����п�����O(N)ʱ���ڽ�����⡣
 * �����������µ���ʱ�����µ�����˫����е�ĩβ�Ƚϣ����ĩβ������С�����ĩβ�ӵ���ֱ���ö��е�ĩβ����������߶���Ϊ�յ�ʱ���ס�֡�
 * ���������ǿ��Ա�֤�������Ԫ���Ǵ�ͷ��β����ģ����ڶ�����ֻ�д����ڵ�����
 * ����������ʵ���Ǵ����ڵ�һ�󣬵ڶ��󣬵�����...������
 * ���ֶ�����ֻ�д��������ķ������ϸ��ⷨһ����Ҳ��ÿ��һ���µİѴ�������ߵ��ӵ���Ȼ����µļӽ�ȥ��
 * Ȼ�����������ڼ�������ʱ���Ѿ��Ѻܶ�û�õ��������ˣ���������ͷ����������һ���Ǵ�������ߵ�����
 * ����ļ����ǣ����Ƕ����д�����Ǹ�����ԭ�����е��±꣬�������Ǽȿ���ֱ���������ֵ��Ҳ����֪�������ǲ��Ǵ�������ߵ�����
 * ����Ϊʲôʱ�临�Ӷ���O(N)�أ���Ϊÿ����ֻ���ܱ�����������Σ�һ���Ǽ�����е�ʱ��һ������Ϊ�б�ĸ������ں��棬���Ա��ӵ���������Ϊ���˴��ڶ����ӵ���
 * @author MG
 *
 */
public class ImportantSlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){ 
        	return new int[0];
        }
        //���д洢�����±�
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        
        for(int i = 0; i < nums.length; i ++){
            // ÿ����������ʱ��������ֶ���ͷ���������±꣬�Ǵ�������������±꣬���ӵ�
            if(!deque.isEmpty() && deque.peekFirst() == i - k) 
            	deque.poll();
            // �Ѷ���β�����б�����С�Ķ��ӵ�����֤�����ǽ����
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) 
            	deque.removeLast();
            // ��������
            deque.offerLast(i);
            // ����ͷ�����Ǹô����ڵ�һ���
            if((i + 1) >= k) 
            	res[i + 1 - k] = nums[deque.peek()];
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{9,10,9,-7,4,-8,2,-6,3,4};
		int k = 5;
		maxSlidingWindow(a,k);
	}
}
