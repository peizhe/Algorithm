package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	private List<Integer> temp = new ArrayList<Integer>();
	private Set<List<Integer>> tempRes = new HashSet<List<Integer>>();
	
	public List<List<Integer>> permuteUnique(int[] nums)  {	
		
        if(nums == null || nums.length == 0){
        	res.add(new ArrayList<Integer>());
        	return res;
        }
        
        permuteAssist(nums, 0);
        
        //将tempRes中的结果存储到res
        Iterator<List<Integer>> iterator = tempRes.iterator(); 
        while(iterator.hasNext()){
        	res.add(iterator.next());
        }
        
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
			tempRes.add(temp);
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
}
