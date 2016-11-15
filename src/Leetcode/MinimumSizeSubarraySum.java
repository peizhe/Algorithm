package Leetcode;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		int begin = 0,sum = 0;
		for (int i = 0; i < nums.length; i ++) {
			sum += nums[i];
			if (sum >= s) {
				// 当前的数的个数与最后的结果进行比较
				int currentCount = i - begin + 1;
				if (currentCount < result) {
					result = currentCount;
				}
				
				//当前的和减去nums[begin]和nums[i],因为下一次循环还要加nums[i]
				sum -= nums[i];
				sum -= nums[begin];
				
				i --;
				begin ++;
			} 			
		}
		
		return result == Integer.MAX_VALUE ? 0 : result;
	}
}
