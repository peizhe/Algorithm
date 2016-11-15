package Leetcode;
//动态规划的思想：和DTW算法建立相似度矩阵有点相似
public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length,col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        //初始化第一列
        for(int i = 0;i < row;i ++){
        	if(obstacleGrid[i][0] == 1){
        		break;
        	}
        	dp[i][0] = 1;
        }
        //初始化第一行
        for(int i = 0;i < col;i ++){
        	if(obstacleGrid[0][i] == 1){
        		break;
        	}
        	dp[0][i] = 1;
        }
        //填充dp数组
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
