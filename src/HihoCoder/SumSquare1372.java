package HihoCoder;

import java.util.Arrays;

/**
 * 题目 : 求一个数组成平方数的和的平方数的最小个数
 * 	例如: 4 = 2 * 2; 4 = 1 * 1 + 1 * 1 + 1 * 1 + 1 * 1 则输出1 
 * 解决办法 :
 * 	1.dfs(超时了) 
 * 	2.dp(下面这种,超时了)
 * 
 * @author MG
 *
 */
public class SumSquare1372 {
    public static int getMinCount(int n) {
        if(n <= 1) return 1;
        
        int max = (int)Math.sqrt(n);
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i <= max; i++) {
        	dp[i * i] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
        	if(dp[i] == Integer.MAX_VALUE) continue;
        	
        	//这样就可以重复使用元素了(精巧)
        	for(int j = 1;j <= max; j++) {
        		int temp = j * j;
        		
        		if(i + temp > n) break;
        		else {
        			dp[i + temp] = Math.min(dp[i + temp], dp[i] + 1);
        		}
        	}
        }
        
        return dp[n];
    }
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		System.out.println(getMinCount(n));
	}
}
