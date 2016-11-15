package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如何记录前驱节点，好好想一下
 * 
 * @author MG
 *
 */
public class LargestDivisibleSubse368 {
	
	public static List<Integer> largestDivisibleSubset1(int[] nums) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
				2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
				1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
				67108864, 134217728, 268435456, 536870912, 1073741824 };
		List<Integer> res = largestDivisibleSubset1(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
