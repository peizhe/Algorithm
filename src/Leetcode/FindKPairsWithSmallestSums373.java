package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 解决本文题的两个经典方法：
 * 	1.用优先队列解决(第二种和第三种)
 * 	2.网友的方法,挺巧妙的(第一种)
 * @author MG
 *
 */
public class FindKPairsWithSmallestSums373 {
	
	public List<int[]> kSmallestPairsAnotherThought(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0 || k <= 0) return ret;
        
        //index2 is used for recording position in nums2 corresponding to given position in nums1
        int[] index2 = new int[nums1.length];
        int len1 = nums1.length,len2 = nums2.length;
        while(k-- > 0){
            int min = Integer.MAX_VALUE;
            //every time we should start from the first place in nums2 to find proper position
            int index = -1;
            for(int i = 0; i < len1; i ++){
                if(index2[i] >= len2) continue;
                
                if(nums1[i] + nums2[index2[i]] < min){
                    min = nums1[i] + nums2[index2[i]];
                    //keep record the index in nums1
                    index = i;
                }
            }
            if(index == -1) break;
            
            int[] temp = {nums1[index], nums2[index2[index]]};
            ret.add(temp);
            index2[index] ++;
        }
        
        return ret;
    }
	
	public List<int[]> kSmallestPairsEasy(final int[] nums1, final int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
        	return res;
        }
        k = k > nums1.length * nums2.length ? nums1.length * nums2.length : k;
        
        int len1 = nums1.length,len2 = nums2.length,i = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(11,new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
			}
		});
        
        for(i = 0;i < len2;i ++){
        	pq.offer(new int[]{0, i});
        }
        
        int[] temp;
        int index1,index2;
        for(i = 0;i < k;i ++){
        	temp = pq.poll();
        	index1 = temp[0];
        	index2 = temp[1];
        	res.add(new int[]{nums1[index1], nums2[index2]});
        	//判断如果nums1走到数组的末尾，则不再向队列中添加元素
        	if(index1 == len1 - 1){
        		continue;
        	}
        	
        	pq.offer(new int[]{index1 + 1,index2});
        }
        
        return res;
    }
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
        	return res;
        }
        k = k > nums1.length * nums2.length ? nums1.length * nums2.length : k;
        
        int len1 = nums1.length,len2 = nums2.length,i = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for(i = 0;i < len2;i ++){
        	pq.offer(new Pair(0, i,nums1[0] + nums2[i]));
        }
        
        Pair temp;
        int index1,index2;
        for(i = 0;i < k;i ++){
        	temp = pq.poll();
        	index1 = temp.index1;
        	index2 = temp.index2;
        	res.add(new int[]{nums1[index1], nums2[index2]});
        	//判断如果nums1走到数组的末尾，则不再向队列中添加元素
        	if(index1 == len1 - 1){
        		continue;
        	}
        	
        	pq.offer(new Pair(index1 + 1, index2, nums1[index1 + 1] + nums2[index2]));
        }
        
        return res;
    }
	
	private class Pair implements Comparable<Pair>{

		int index1;
		int index2;
		int sum;
		
		public Pair(int index1,int index2,int sum){
			this.index1 = index1;
			this.index2 = index2;
			this.sum = sum;
		}
		
		public int compareTo(Pair o) {
			return this.sum - o.sum;
		}
	}
}
