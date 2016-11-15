package Algorithm;

import java.util.Arrays;

/**
 * 求最长上升序列长度的几种方法：
 * 	1.dfs : 耗时
 * 	2.dp : O(n ^ 2)
 * 	3.更屌的方法(O(nlogn),高效率)
 * @author MG
 *
 */
public class LongestIncreasingSeries {
	
	private static int lisDP(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int res = 1;
		int len = nums.length;
		int[] dp = new int[len];
		
		for(int i = 0;i < len;i ++){
			dp[i] = 1;
			for(int j = 0;j < i;j ++){
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			res = Math.max(dp[i], res);
		}
		
		return res;
	}
	
	/**
	 * 只计算长度使用这个最快，如果求出最长序列不能使用
	 * @param nums
	 * @return
	 */
	private static int lisBest(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int len = nums.length;
		int[] stack = new int[len];
		
		int res = 0;
		for(int i : nums) {
			int index = Arrays.binarySearch(stack, 0, res, i);
			//这是二分查找源码中返回的(如果没找到，则返回 -(index + 1))
            if(index < 0)
                index = -(index + 1);
            
            stack[index] = i;
            
            if(index == res)
                res ++;
		}
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,3,2,4,5,7,6,8};
		System.out.println(lisDP(nums) + " " + lisBest(nums));
	}

}
