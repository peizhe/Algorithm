package Leetcode;

/**
 * 题目 : 把一个数组分成两个数组，使得两个数组的和相等，判断能不能分出来
 * 	思路：求得所有元素的和，然后得到和的一半，然后求数组中的元素有没有等于和的一半
 * 	1.求一个数组中元素等于某一个数
 * 		(1)dp方法(能用dp的方法尽量不使用dfs),好好学习一下这种写法
 * 		(2)dfs(dfs都超时了)
 * @author MG
 *
 */
public class PartitionEqualSubsetSum416 {
	
	public static boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0){
			return true;
		}
		
		int sum = 0;
		for(int i : nums){
			sum += i;
		}
		if((sum & 1) == 1) return false;
		
		sum /= 2;
		
		int len = nums.length;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		
        // replace nums[i - 1] with nums[i]
        for(int i = 0;i < len; i++) {
            for(int j = sum;j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j - nums[i]];
            
        }
        return dp[sum];		
    }	
	
	public static void main(String[] mh){
		int[] nums = new int[]{1,5,5,11};
		System.out.println(canPartition(nums));
	}
}
