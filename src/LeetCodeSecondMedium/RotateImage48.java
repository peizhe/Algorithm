package LeetCodeSecondMedium;

public class RotateImage48 {
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        	
        int row = matrix.length, col = matrix[0].length;
        
        int top = 0, down = row - 1;
        //上下对换
        while(top < down) {
        	int[] temp = matrix[top];
        	matrix[top] = matrix[down];
        	matrix[down] = temp;
        	
        	top ++;
        	down --;
        }
        
        //按对角线对折
        for(int i = 0; i < row; i++) {
        	for(int j = i + 1; j < col; j++) {
        		if(matrix[i][j] != matrix[j][i]) {
        			matrix[i][j] ^= matrix[j][i];
        			matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        			matrix[i][j] ^= matrix[j][i];
        		}
        	}
        }
    }
}
