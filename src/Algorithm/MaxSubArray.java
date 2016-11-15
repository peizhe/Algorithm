package Algorithm;

/**
 * 连续子序列和
 * @author MG
 *
 */
public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		int temp = nums[0];
		for(int i = 1;i < nums.length;i ++) {
			//下面两个是状态方程，很重要
			temp = Math.max(nums[i], temp + nums[i]);
			result = Math.max(result, temp);
		}
		return result;
	}
	public static void main(String[] mh) {
	}

}
