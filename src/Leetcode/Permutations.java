package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	private ArrayList<Integer> temp = new ArrayList<Integer>();
	
	public List<List<Integer>> permute(int[] nums) {	
		
        if(nums == null || nums.length == 0){
        	res.add(temp);
        	return res;
        }
        
        permuteAssist(nums, 0);
        return res;
    }
	
	//将数组转换成链表
	private void convert(int[] nums){
		for(int i = 0;i < nums.length;i ++){
			temp.add(nums[i]);
		}
	}
	
	private void permuteAssist(int[] nums,int index){
		if(index >= nums.length){
			convert(nums);
			res.add(temp);
			temp = new ArrayList<Integer>();
			return;
		}
		
		for(int i = index;i < nums.length;i ++){
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
			
			permuteAssist(nums, index + 1);
			
			temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
		}
	}
	
	
	public static void main(String[] mh){
		Permutations p = new Permutations();
		int[] nums = {1,2,3,4,5};
		p.permute(nums);
		for(int i = 0;i < p.res.size();i ++){
			for(int j = 0;j < p.res.get(i).size();j ++){
				System.out.print(p.res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
