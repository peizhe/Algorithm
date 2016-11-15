package Algorithm;

import java.util.Arrays;

/**
 * ����һ������nums��һ��Ŀ��ֵtarget,��������Ԫ�غ�Ϊtargetϵ������
 * 	1.Ԫ�������ظ�ʹ�� :
 * 		(1)����ڵ����� ���� ��Ϊtarget��Ԫ�����ٸ���(1.dfs,2.dp)
 *		(2)��ÿһ��Ԫ�ع���(һ����dfs)
 *
 *	2.Ԫ�ز������ظ�ʹ�� :
 *		(1)����ڵ�����(dfs) ���� �ж��Ƿ���ں�Ϊtarget��Ԫ�����(dp)
 *		(2)��ÿһ��Ԫ�ع���(һ����dfs)
 * 
 * @author MG
 *
 */
public class CombineSum {
	
	/**
	 * ����Ԫ���ظ�dp
	 * 	1.��������
	 * 
	 * @param nums Ԫ�� >= 0
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
	 * ����Ԫ���ظ�dp
	 * 	1.�����Ϊtarget��Ԫ�ظ�������Ϊ����
	 * 
	 * @param nums Ԫ�� >= 0
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
	 * ������Ԫ���ظ�ʹ��dp
	 * 	1. �ж��Ƿ���ں�Ϊtarget��Ԫ�����
	 * 
	 * @param nums Ԫ�� >= 0
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
