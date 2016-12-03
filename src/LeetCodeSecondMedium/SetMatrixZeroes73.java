package LeetCodeSecondMedium;

import java.util.Arrays;

public class SetMatrixZeroes73 {
	public void setZeroes(int[][] matrix) {
        boolean rowFlag = false, colFlag = false;
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < col; i++) {
        	if(matrix[0][i] == 0) {
        		rowFlag = true;
        		break;
        	}
        }
        
        for(int i = 0; i < row; i++) {
        	if(matrix[i][0] == 0) {
        		colFlag = true;
        		break;
        	}
        }
        
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        
        for(int i = 1; i < row; i++) {
        	if(matrix[i][0] == 0) Arrays.fill(matrix[i], 0);
        }
        
        for(int i = 1; i < col; i++) {
        	if(matrix[0][i] == 0) {
        		for(int j = 1; j < row; j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        
        if(rowFlag) Arrays.fill(matrix[0], 0);
        
        if(colFlag) {
        	for(int i = 0; i < row; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
}
