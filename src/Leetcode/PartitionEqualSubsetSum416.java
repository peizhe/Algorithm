package Leetcode;

/**
 * ��Ŀ : ��һ������ֳ��������飬ʹ����������ĺ���ȣ��ж��ܲ��ֳܷ���
 * 	˼·���������Ԫ�صĺͣ�Ȼ��õ��͵�һ�룬Ȼ���������е�Ԫ����û�е��ں͵�һ��
 * 	1.��һ��������Ԫ�ص���ĳһ����
 * 		(1)dp����(����dp�ķ���������ʹ��dfs),�ú�ѧϰһ������д��
 * 		(2)dfs(dfs����ʱ��)
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
