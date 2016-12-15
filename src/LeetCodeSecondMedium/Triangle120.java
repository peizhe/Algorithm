package LeetCodeSecondMedium;

import java.util.List;

public class Triangle120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int row = triangle.size();
        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < row; i++) {
        	//这里i同样可以表示当前这一行的最大下标
        	dp[i] = dp[i - 1] + triangle.get(i).get(i);
        			
        	for(int j = i - 1; j > 0; j--) {
        		dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j); 
        	}
        	//这一句一定要放在后面
        	dp[0] = dp[0] + triangle.get(i).get(0);
        }
        
        int res = Integer.MAX_VALUE;
        for(int x : dp) res = x < res ? x : res;
        
        return res;
    }
}
