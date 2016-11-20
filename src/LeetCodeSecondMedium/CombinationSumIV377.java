package LeetCodeSecondMedium;

import java.util.Arrays;

/**
 * 1.dfs(时间复杂度高)
 * 2.dp
 * 
 * 
 * @author MG
 *
 */
public class CombinationSumIV377 {
	
	public static int combinationSum4DP(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int[] dp = new int[target + 1];
		for(int i : nums) {
			if(i > target) continue;
			dp[i] = 1;
		}
		
		for(int i = 1; i <= target; i++) {
			for(int j = 0; j < len; j++) {
				dp[i] += i - nums[j] > 0 ? dp[i - nums[j]] : 0;
			}
		}
		
		return dp[target];
	}
	
	public static int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        
        Arrays.sort(nums);
        
        return helper(nums, target);
    }
	
	private static int helper(int[] nums, int target) {
		if(target == 0) return 1;
		else if(target < 0) return 0; 
		else {
			int res = 0;
			
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] > target) break;
				
				res += helper(nums, target - nums[i]);
			}
			
			return res;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3};
		int target = 32;
		
		System.out.println(combinationSum4(nums, target));
	}

}
