package LeetCodeSecondMedium;

import java.util.Arrays;

/**
 * ���������:
 * 	1.dfs���Խ��(�ݹ�ķ���,ʱ�临�ӶȱȽϸ�)
 * 	2.��̬�滮�ķ���(Ч�ʸ���)
 * @author MG
 *
 */
public class CoinChange322 {
	/**
	 * ʡȥ������Ĺ��̣��úÿ�����Ч�ʸߵĴ���
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
