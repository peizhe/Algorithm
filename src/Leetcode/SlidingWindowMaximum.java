package Leetcode;

import java.util.LinkedList;

public class SlidingWindowMaximum {
	
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
}
