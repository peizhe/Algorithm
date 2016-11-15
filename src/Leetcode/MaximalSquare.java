package Leetcode;
/**
 * dynamic programing.  
 * 	以当前点(x,y) = '1'为右下角的最大正方形的边长
 * 	f(x,y) = min(f(x-1,y),f(x,y-1),f(x-1,y-1)) + 1.
 * 	递推公式已建立, dp就自然而然了
 * @author MG
 */
public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		//row代表行，col代表列
		int colLength = matrix[0].length,rowLength = matrix.length;
		
		int[][] a = new int[rowLength][colLength];
		
		int max = 0;
		for(int i = 0;i < colLength;i ++){
			if(matrix[0][i] == '1'){
				a[0][i] = 1;
				max = 1;
			}
		}
		
		for(int i = 0;i < rowLength;i ++){
			if(matrix[i][0] == '1'){
				a[i][0] = 1;
				max = 1;
			}
		}
		
		for(int i = 1;i < rowLength;i ++){
			for(int j = 1;j < colLength;j ++){
				if(matrix[i][j] == '0'){
					a[i][j] = 0;
				}else{
					a[i][j] = Math.min(Math.min(a[i - 1][j - 1], a[i - 1][j]), a[i][j - 1]) + 1;
					max = Math.max(max, a[i][j]);
				}
			}
		}
		
		return max * max;
    }
}
