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
				// ��ǰ�����ĸ��������Ľ�����бȽ�
				int currentCount = i - begin + 1;
				if (currentCount < result) {
					result = currentCount;
				}
				
				//��ǰ�ĺͼ�ȥnums[begin]��nums[i],��Ϊ��һ��ѭ����Ҫ��nums[i]
				sum -= nums[i];
				sum -= nums[begin];
				
				i --;
				begin ++;
			} 			
		}
		
		return result == Integer.MAX_VALUE ? 0 : result;
	}
}
