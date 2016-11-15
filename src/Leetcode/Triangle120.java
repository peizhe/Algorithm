package Leetcode;

import java.util.List;

public class Triangle120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
        	return 0;
        }
        int row = triangle.size();
        
        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);
        
        for(int i = 1;i < row;i ++){
        	dp[i] = dp[i - 1] + triangle.get(i).get(i);
        	//从后向前填充数组就不会改变前一个变量的值了，这样就保留了上一轮的值
        	for(int j = i - 1;j > 0;j --){
        		dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
        	}
        	dp[0] += triangle.get(i).get(0);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i : dp){
        	res = i < res ? i : res;
        }
        
        return res;
    }
}
