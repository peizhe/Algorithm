package Leetcode;

public class Searcha2DMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
			return false;
		}
		
		//求的是index
		int index = 0;
		//如果第一列最后一个数小于target,则直接搜索最后一行
		if(matrix[matrix.length - 1][0] <= target){
			index = matrix.length - 1;
			return find(matrix,target,index);
		}
		
		//否则，搜索第一列，找到最后一个比target小的数的index
		else{
			int begin = 0,end = matrix.length - 1;
			while(begin <= end){
				int mid = begin + (end - begin) / 2;
				if(matrix[mid][0] > target){
					end = mid - 1;
				}
				else if(matrix[mid][0] < target){
					begin = mid + 1;
				}
				else{
					return true;
				}
			}
			index = begin - 1;
			
			if(matrix[0].length == 1){
				return false;
			}
			
			else{
				return find(matrix,target,index);
			} 
		}
    } 
	
	private static boolean find(int[][] matrix, int target,int index){
		int left = 0,right = matrix[0].length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(matrix[index][mid] < target){
				left = mid + 1;
			}
			else if(matrix[index][mid] > target){
				right = mid - 1;
			}
			else{
				return true;
			}
		}
		return false;
	}
}
