package LeetCodeSecondMedium;

import java.util.*;

public class Permutations46 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();
	public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
        	return res;
        }
        dfs(nums, 0, nums.length);
        return res;
    }
	
	private void dfs(int[] nums,int current,int length){
		if(current == length){
			for(int i : nums){
				temp.add(i);
			}
			res.add(new ArrayList<Integer>(temp));
			temp.clear();
			return;
		}
		
		for(int i = current;i < length;i ++){
			//先交换
			swap(nums, i, current);
			dfs(nums,current + 1,length);
			//将前面交换的进行复位
			swap(nums, i, current);
		}
	}
	
	private void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3};
		new Permutations46().permute(nums);
	}

}
