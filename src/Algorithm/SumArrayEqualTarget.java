package Algorithm;
/**
 * 判断一个数组中是否存在某些元素之和等于指定值
 * 	1.dfs(可以实现，复杂度较高)
 * 	2.递归实现
 * @author MG
 *
 */
public class SumArrayEqualTarget {
	public boolean sumToTarget(int[] nums,int target){
		int len = nums.length;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		
        for(int i = 0;i < len; i++) {
            for(int j = target;j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j - nums[i]];
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
