package Leetcode;

public class BestTimeBuySellStockIII123 {
	/**
	 * 更简单的算法
	 * 	和第二题的思想是一样的，写法简单的多
	 * @param prices
	 * @return
	 */
	public static int maxProfitBetter(int[] prices) {
		int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for(int i = 0; i < prices.length; i++){
            oneBuy = Math.max(oneBuy, -prices[i]);//we set prices to negative, so the calculation of profit will be convenient
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);//we can buy the second only after first is sold
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }
        
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
	
	/**
	 * 动态规划，时间复杂度O(n),空间复杂度O(n)
	 * 
	 * dp[K][i] represents the max profit up until prices[i](不包括prices[i])
	 * 		(Note: NOT ending with prices[i]) using at most k transactions. 
	 * 
	 * 寻找dp[K - 1][j] + prices[i] - prices[j] 的最大值 赋值给dp[K][i],0 <= j <= i - 1
	 * dp[K][i] = max(dp[K][i - 1], prices[i] - prices[j] + dp[K - 1][j]) {j in range of [0, i - 1] }
	 *          = max(dp[K][i - 1], prices[i] + max(dp[K - 1][j]  - prices[j]))
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
	
        else {
            int K = 2, len = prices.length;
            int maxProf = 0;
            int[][] dp = new int[K + 1][len];
            for (int j = 1; j <= K; j++) {
                int tmpMax = dp[j - 1][0] - prices[0];
                for (int i = 1; i < len; i++) {
                    dp[j][i] = Math.max(dp[j][i - 1], prices[i] + tmpMax);
                    tmpMax = Math.max(tmpMax, dp[j - 1][i] - prices[i]);
                    
                    maxProf = Math.max(dp[j][i], maxProf);
                }
            }
            
            return maxProf;
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[]{1,4,6,2,5,3,4,6};
		System.out.println(maxProfit(prices));
	}

}
