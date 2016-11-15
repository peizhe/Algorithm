package Leetcode;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
	public int findKthLargest1(int[] nums, int k) {
        // ��ס�������ݽṹ�����ȶ��У�Ҳ��С���ѣ�
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) 
                p.poll();
        }
        return p.poll();
    }
}
