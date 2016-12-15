package LeetCodeSecondMedium;

import java.util.List;

public class Triangle120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        
        int row = triangle.size();
        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < row; i++) {
        	//����iͬ�����Ա�ʾ��ǰ��һ�е�����±�
        	dp[i] = dp[i - 1] + triangle.get(i).get(i);
        			
        	for(int j = i - 1; j > 0; j--) {
        		dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j); 
        	}
        	//��һ��һ��Ҫ���ں���
        	dp[0] = dp[0] + triangle.get(i).get(0);
        }
        
        int res = Integer.MAX_VALUE;
        for(int x : dp) res = x < res ? x : res;
        
        return res;
    }
}
