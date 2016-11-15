package Leetcode;

import java.util.Arrays;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i <= nums[nums.length - 1]; i++) {
			sum = sum + i;
		}
		int sum1 = 0;
		for (int i = 0; i < nums.length; i++) {
			sum1 = sum1 + nums[i];
		}
		return (sum - sum1 == 0) ? ((nums[0] == 0) ? nums[nums.length - 1] + 1
				: 0) : (sum - sum1);
	}

	public static void main(String[] mh) {
		MissingNumber mn = new MissingNumber();
		int[] nums = { 0 };
		System.out.println(mn.missingNumber(nums));
	}
}
