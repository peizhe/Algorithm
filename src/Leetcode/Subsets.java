package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//加入空集
		result.add(new ArrayList<Integer>());
		for(int i = 0;i < nums.length;i ++){
			List<List<Integer>> newList = new ArrayList<List<Integer>>();
			
			for(List<Integer> a : result){
				newList.add(new ArrayList<Integer>(a));
			}
			
			for(List<Integer> a : newList){
				List<Integer> tep = new ArrayList<Integer>(a);
				tep.add(nums[i]);
				result.add(tep);
			}
		}
		return  result;
    }
	
	//只是为了练手，这道题没用自己写的排序
	public static int[] quickSort(int[] nums,int left,int right){
		if(left < right){
			int key = nums[left];
			int begin = left,end = right;
			while(begin < end){
				while(begin < end && nums[end] > key){
					end --;
				}
				nums[begin] = nums[end];
				
				while(begin < end && nums[begin] < key){
					begin ++;
				}
				
				nums[end] = nums[begin];
			}
			
			nums[begin] = key;
			
			quickSort(nums,left,begin - 1);
			quickSort(nums,begin + 1,right);
		}
		return nums;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3};
		subsets(a);
		a = quickSort(a, 0, a.length - 1);
		for(int i = 0;i < a.length;i ++){
			System.out.print(a[i] + " ");
		}
	}
}
