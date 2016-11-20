package LeetCodeSecondMedium;

import java.util.List;
import java.util.ArrayList;

public class PermutationsTemp46 {
	public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, res, temp, 0, nums.length);
        
        return res;
    }
	
	private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int begin, int end) {
		if(begin >= end) {
			for(int i : nums) {
				temp.add(i);
			}
			
			res.add(new ArrayList<>(temp));
			temp.clear();
			return;
		}
		
		for(int i = begin; i < end; i++) {
			swap(nums, begin, i);
			helper(nums, res, temp, begin + 1, end);
			swap(nums, begin, i);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		if(nums[i] != nums[j]) {
			nums[i] = nums[i] ^ nums[j];
			nums[j] = nums[i] ^ nums[j];
			nums[i] = nums[i] ^ nums[j];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
