package Algorithm;

import java.util.Arrays;

/**
 * 给定一个数组nums和一个目标值target,求数组中元素和为target系列问题
 * 	1.元素允许重复使用 :
 * 		(1)求存在的种数 或者 和为target的元素最少个数(1.dfs,2.dp)
 *		(2)求每一种元素构成(一般是dfs)
 *
 *	2.元素不允许重复使用 :
 *		(1)求存在的种数(dfs) 或者 判断是否存在和为target的元素组合(dp)
 *		(2)求每一种元素构成(一般是dfs)
 * 
 * @author MG
 *
 */
public class CombineSum {
	
	/**
	 * 允许元素重复dp
	 * 	1.计算种数
	 * 
	 * @param nums 元素 >= 0
	 * @param target target >= 0
	 * @return
	 */
	public static int getCountDuplicate(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[target + 1];
		for(int i : nums) {
			if(i > target) continue;
			dp[i] = 1;
		}
		
		for(int i = 0; i <= target; i++) {
			if(dp[i] == 0) continue;
			for(int j = 0; j < len; j++) {
				if(i + nums[j] > target) continue;
				else {
					dp[i + nums[j]] = dp[i] + 1;
				}
			}
		}
		
		return dp[target];
	}
	
	/**
	 * 允许元素重复dp
	 * 	1.计算和为target中元素个数最少为几个
	 * 
	 * @param nums 元素 >= 0
	 * @param target target >= 0
	 * @return
	 */
	public static int getCountDuplicateMin(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[target + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i : nums) {
			if(i > target) continue;
			dp[i] = 1;
		}
		
		for(int i = 0; i <= target; i++) {
			if(dp[i] == 0) continue;
			for(int j = 0; j < len; j++) {
				if(i + nums[j] > target) continue;
				else {
					dp[i + nums[j]] = Math.min(dp[i + nums[j]], dp[i] + 1);
				}
			}
		}
		
		return dp[target];
	}

	
	/**
	 * 不允许元素重复使用dp
	 * 	1. 判断是否存在和为target的元素组合
	 * 
	 * @param nums 元素 >= 0
	 * @param target target >= 0
	 * @return
	 */
	public static boolean isExistNoDuplicate(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		int len = nums.length;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		
		for(int i = 0; i < len; i++) {
			for(int j = target; j >= nums[i]; j--) {
				dp[j] |= dp[j - nums[i]];
			}
		}
		
		return dp[target];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
