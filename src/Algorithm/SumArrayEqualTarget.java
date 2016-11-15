package Algorithm;
/**
 * �ж�һ���������Ƿ����ĳЩԪ��֮�͵���ָ��ֵ
 * 	1.dfs(����ʵ�֣����ӶȽϸ�)
 * 	2.�ݹ�ʵ��
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
