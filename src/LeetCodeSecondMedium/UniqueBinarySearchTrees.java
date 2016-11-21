package LeetCodeSecondMedium;

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) { 
		if(n <= 0) return 0;
		
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			//必须一个节点作为根节点
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}
		
		return dp[n];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
