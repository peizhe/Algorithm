package Note;

public class Problem {
	
	/**
	 * Ǯ���������� :
	 * 	1.dfs
	 * 	2.dp
	 * 
	 * �����ص� :
	 * 	ÿһ����ֵ��Ǯ�����������޵ģ������ظ�ʹ��
	 * 
	 * ��������:
	 *  1.Ҫ��ʹ��Ǯ����������
	 *    -- dp(Coin Change 322)
	 *  2.��Ǯ�ķ�ʽ������(ͬ����(����Ԫ�ؿ��ظ�ʹ��)�к�Ϊĳһ����������ͬ)
	 *  
	 * @author MG
	 *
	 */
	public static class Coins{}
	
	/**
	 * �ж�һ���������Ƿ���ں�Ϊĳһ��(ÿһ��������ʹ��һ��) :
	 * 	1.dfs
	 * 	2.dp
	 * 
	 * �����ص� :
	 * 	ÿһ����ֻ��ʹ��һ��
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
	 * һ�������к�Ϊĳһ����������(ÿһ���������ظ�ʹ��)
	 * 	1.dfs
	 * 	2.dp (CombinationSumIV377)
	 * 
	 * �����ص� :
	 * 	ÿһ����������ʹ�ö��	
	 * 
	 * @author MG
	 *
	 */
	public static class sumToTargetII{}
	
	/**
	 * ��������
	 * 	1.dp
	 * 
	 * �����ص� :
	 * 	ÿ��Ԫ��ֻ��ʹ��һ��
	 * 
	 * @author MG
	 *
	 */
	public static class PackageProblem{} 
}
