package Interview;

import java.util.PriorityQueue;

public class PartSort {
	public static int[] findArrSort(int[] nums,int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int len = nums.length;
		int[] res = new int[len];
		for(int i = 0;i < k;i ++){
			pq.add(nums[i]);
		}
		
		for(int i = 0;i < k;i ++){
			res[i] = pq.poll();
		}
		
		pq.clear();
		for(int i = k;i < len;i ++){
			pq.add(nums[i]);
		}
		
		for(int i = k;i < len;i ++){
			res[i] = pq.poll();
		}
		
		return res;
	}
	
	public static void main(String[] mh){
		int[] a = new int[]{9,8,7,6,5,4,3,2,1};
		int[] res = findArrSort(a, 3);
		
		for(int i : res){
			System.out.print(i + " ");
		}
	}
}
