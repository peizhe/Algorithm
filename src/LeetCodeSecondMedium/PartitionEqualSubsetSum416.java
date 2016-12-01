package LeetCodeSecondMedium;

public class PartitionEqualSubsetSum416 {
	
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        
        int sum = 0;
        for(int i : nums) sum += i;
        
        if((sum & 1) == 1) return false;
        
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i : nums) {
        	for(int j = sum; j >= i; j--) {
        		dp[j] |= dp[j - i];
        	}
        }
        
        return dp[sum];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
