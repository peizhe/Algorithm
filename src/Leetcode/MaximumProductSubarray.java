package Leetcode;

//动态规划问题
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int result = nums[0];
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			// 三个状态方程，很重要！！！
			max = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
			min = Math.min(Math.min(nums[i], nums[i] * temp), nums[i] * min);
			result = Math.max(max, result);
		}
		
		return result;
	}
}
