package Leetcode;
//��̬�滮��˼�룺��DTW�㷨�������ƶȾ����е�����
public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length,col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        //��ʼ����һ��
        for(int i = 0;i < row;i ++){
        	if(obstacleGrid[i][0] == 1){
        		break;
        	}
        	dp[i][0] = 1;
        }
        //��ʼ����һ��
        for(int i = 0;i < col;i ++){
        	if(obstacleGrid[0][i] == 1){
        		break;
        	}
        	dp[0][i] = 1;
        }
        //���dp����
        for(int i = 1;i < row;i ++){
        	for(int j = 1;j < col;j ++){
        		if(obstacleGrid[i][j] == 1){
        			dp[i][j] = 0;
        		}
        		else{
        			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        		}
        	}
        }
        
        return dp[row - 1][col - 1];
    }
}
