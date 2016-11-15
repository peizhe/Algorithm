package Leetcode;

//��̬�滮���ҵ�״̬ת�Ʒ���
public class MaximumSubarray1 {
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// ����������״̬���̣�����Ҫ
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
