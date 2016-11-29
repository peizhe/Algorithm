package LeetCodeSecondMedium;

public class SearchA2DMatrixII240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int top = 0, right = col - 1;
        
        while(top < row && right >= 0) {
        	if(matrix[top][right] == target) {
        		return true;
        	} else if(matrix[top][right] < target) {
        		top ++;
        	} else {
        		right --;
        	}
        }
        
        return false;
    }
}
