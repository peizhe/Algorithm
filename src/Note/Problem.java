package Note;

public class Problem {
	
	/**
	 * 钱的找零问题 :
	 * 	1.dfs
	 * 	2.dp
	 * 
	 * 问题特点 :
	 * 	每一种面值的钱数量都是无限的，可以重复使用
	 * 
	 * 变种问题:
	 *  1.要求使用钱币数量最少
	 *    -- dp(Coin Change 322)
	 *  2.找钱的方式的种数(同数组(数组元素可重复使用)中和为某一个数问题相同)
	 *  
	 * @author MG
	 *
	 */
	public static class Coins{}
	
	/**
	 * 判断一个数组中是否存在和为某一数(每一个数限制使用一次) :
	 * 	1.dfs
	 * 	2.dp
	 * 
	 * 问题特点 :
	 * 	每一个数只能使用一次
	 * 
	 * @author MG
	 *
	 */
	public static class sumToTargetI{
		//PartitionEqualSubsetSum416
		public static boolean canPartition(int[] nums, int sum) {
			if(nums == null || nums.length == 0){
				return true;
			}
			
			int len = nums.length;
			boolean[] dp = new boolean[sum + 1];
			dp[0] = true;
			
	        // replace nums[i - 1] with nums[i]
	        for(int i = 0;i < len; i++) {
	            for(int j = sum;j >= nums[i]; j--)
	                dp[j] |= dp[j - nums[i]];
	        }
	        
	        return dp[sum];		
	    }	
	}
	
	/**
	 * 一个数组中和为某一个数的种数(每一个数可以重复使用)
	 * 	1.dfs
	 * 	2.dp (CombinationSumIV377)
	 * 
	 * 问题特点 :
	 * 	每一个数都可以使用多次	
	 * 
	 * @author MG
	 *
	 */
	public static class sumToTargetII{}
	
	/**
	 * 背包问题
	 * 	1.dp
	 * 
	 * 问题特点 :
	 * 	每个元素只能使用一次
	 * 
	 * @author MG
	 *
	 */
	public static class PackageProblem{} 
}
