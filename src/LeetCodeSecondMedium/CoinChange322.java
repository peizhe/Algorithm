package LeetCodeSecondMedium;

import java.util.Arrays;

/**
 * 找零的问题:
 * 	1.dfs可以解决(递归的方法,时间复杂度比较高)
 * 	2.动态规划的方法(效率更高)
 * @author MG
 *
 */
public class CoinChange322 {
	/**
	 * 省去了排序的过程，好好看看这效率高的代码
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		if (amount < 1) return 0;
		
        int[] dp = new int[amount + 1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int coin : coins) {
            for (int i = coin;i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = new int[]{1,2147483647};
		int target = 2;
		System.out.println(coinChange(coins, target));
	}

}
