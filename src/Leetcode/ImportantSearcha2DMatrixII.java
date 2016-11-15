package Leetcode;
/**
 * �����Ͻǽ������������target > matrix[i][j],��֤��������һ�У���i ++
 * ���target < matrix[i][j],��֤��������һ�У���j --
 * ���target = matrix[i][j],�򷵻�
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
		
		//�����߽磬�򷵻�false
		return false;
    }
}
