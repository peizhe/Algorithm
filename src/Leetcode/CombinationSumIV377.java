package Leetcode;

/**
 * 
 * @author MG
 *
 */
public class CombinationSumIV377 {
	public static int combinationSum4(int[] nums, int target) {
		if(nums == null || target <= 0){
			return 0; 
		}
		
		int len = nums.length;
		int[] dp = new int[target + 1];
		
		for(int j = 0;j < len;j ++){
			if(nums[j] > target) continue;
			dp[nums[j]] = 1;
		}
				
		for(int i = 0;i <= target;i ++){
			for(int j = 0;j < len;j ++){
				if(dp[i] == 0) break;
				
				if(i + nums[j] <= target){
					//ÕâÊÇ¹Ø¼ü
					dp[i + nums[j]] += dp[i];
				}
			}
		}
		
		return dp[target]; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3,1,2,5};
		int target = 4;
		
		System.out.println(combinationSum4(nums, target));
	}
}
