package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		
		helper(res, new ArrayList<Integer>(), candidates, 0, target);
		
        return res;
    }
	
	private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int current, int target) {
		if(target < 0) return;
		
		if(target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		} 
		
		for(int i = current; i < nums.length; i++) {
			if(nums[i] > target) break;
			
			temp.add(nums[i]);
			helper(res, temp, nums, i, target - nums[i]);
			temp.remove(temp.size() - 1);
		}
	}
}
