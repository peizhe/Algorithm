package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset368 {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums == null || nums.length == 0){
			return new ArrayList<Integer>();
		}
		Arrays.sort(nums);
		
		int len = nums.length;
		int[] dp = new int[len];
		int[] pre = new int[len];
		
		int lastIndex = 0;
		int maxLen = 1;
		
		dp[0] = 1;
		for(int i = 1;i < len; i++){
			int tempMaxIndex = i;
			//找到dp[0,...,i - 1]中nums[i] % nums[j] == 0并且最大的dp[j]
			for(int j = i - 1;j >= 0; j--){
				if(nums[i] % nums[j] == 0 && dp[j] > dp[tempMaxIndex]){
					tempMaxIndex = j;
				}
			}
			dp[i] = dp[tempMaxIndex] + 1;
			pre[i] = tempMaxIndex;
			
			if(dp[i] > maxLen){
				maxLen = dp[i];
				lastIndex = i;
			}
		}
		
		List<Integer> res = new ArrayList<Integer>();
		while(lastIndex != pre[lastIndex]){
			res.add(nums[lastIndex]);
			
			lastIndex = pre[lastIndex];
		}
		
		res.add(nums[lastIndex]);
		
		return res;
	}

	public static void main(String[] mh) {
		int[] nums = {1,2,3};
		System.out.println(largestDivisibleSubset(nums));
	}
}

