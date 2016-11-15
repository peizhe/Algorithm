package Leetcode;

//动态规划，找到状态转移方程
public class MaximumSubarray1 {
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 下面两个是状态方程，很重要
			temp = Math.max(nums[i], temp + nums[i]);
			result = Math.max(result, temp);
		}
		return result;
	}

	public static void main(String[] mh) {
		int[] a = { -2, -3, -1, -5, -4 };
		MaximumSubarray1 ms = new MaximumSubarray1();
		System.out.println(ms.maxSubArray(a));
	}
}
