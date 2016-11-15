package Leetcode;
/**
 * 从右上角进行搜索，如果target > matrix[i][j],则证明不在这一行，则i ++
 * 如果target < matrix[i][j],则证明不在这一列，则j --
 * 如果target = matrix[i][j],则返回
 * @author mh
 *
 */
public class ImportantSearcha2DMatrixII {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
			return false;
		}
		
		int i = 0,j = matrix[0].length - 1;
		while(i < matrix.length && j >= 0){
			if(matrix[i][j] > target){
			    j --;
			}
			
			else if(matrix[i][j] < target){
				i ++;
			}
			
			else{
				return true;
			}
		}
		
		//碰到边界，则返回false
		return false;
    }
}
