package Leetcode;

public class RotateArray {
	//这个方法比较巧，将前半部分和后半部分分别逆序，再总的逆序
	public void rotate(int[] nums, int k) {
		int length = nums.length;

		k = k % length;

		if (length == 1)
			return;

		if (k == 0)
			return;

		reversal(nums, 0, length - 1 - k);
		reversal(nums, length - k, length - 1);
		reversal(nums, 0, length - 1);
	}

	public void reversal(int[] nums, int i, int j) {
		int t = 0;
		while (i < j && i >= 0) {
			t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}
	}
}
