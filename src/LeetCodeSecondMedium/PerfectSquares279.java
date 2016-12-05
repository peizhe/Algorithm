package LeetCodeSecondMedium;

import java.util.Arrays;

public class PerfectSquares279 {
	public int numSquares(int n) {
		if(n <= 0) return 0;
		
		int max = (int)Math.sqrt(n);
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i <= max; i++) {
			dp[i * i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1;j <= max; j++) {
				int des = i + j * j;
				if(des > n) break;
				
				dp[des] = Math.min(dp[des], dp[i] + 1);
			}
		}
		
		return dp[n];
	}
}
