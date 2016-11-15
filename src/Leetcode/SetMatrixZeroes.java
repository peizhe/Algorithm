package Leetcode;
/**
 * 这道题space复杂度降到了最低，通过第一行第一列来存储0的位置
 * 1.先确定第一行和第一列是否需要清零,即，看看第一行中是否有0，记下来。也同时记下来第一列中有没有0。
 * 2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
 * 这里不用担心会将本来第一行或第一列的1改成了0，因为这些值最后注定要成为0的，比如matrix[i][j]==0，那么matrix[i][0]处在第i行，matrix[0][j]处于第j列，最后都要设置为0的。
 * 3.根据第一行和第一列的信息，已经可以将剩下的矩阵元素赋值为结果所需的值了即，拿第一行为例，如果扫描到一个0，就将这一列都清0.
 * 4.根据1中确定的状态，处理第一行和第一列。如果最开始得到的第一行中有0的话，就整行清零。同理对列进行处理。
 * @author MG
 *
 */
public class SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		if(row == 0){
			return;
		}
		int col = matrix[0].length;
		if(col == 0){
			return;
		}
		
		boolean firstRowIsZero = false;
		boolean firstColIsZero = false;
		
		//判断第一行是否有0
		for(int i = 0;i < matrix[0].length;i ++){
			if(matrix[0][i] == 0){
				firstRowIsZero = true;
				break;
			} 
		}
		//判断第一列是否有零
		for(int i = 0;i < matrix.length;i ++){
			if(matrix[i][0] == 0){
				firstColIsZero = true;
				break;
			}
		}
		
		for(int i = 1;i < matrix.length;i ++){
			for(int j = 1;j < matrix[0].length;j ++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//遍历第一列中的0
		for(int i = 1;i < matrix.length;i ++){
			if(matrix[i][0] == 0){
				//第一列中的第i个元素为0，则将第i行全部赋值为0
				for(int j = 1;j < matrix[0].length;j ++){
					matrix[i][j] = 0;
				}
			}
		}
		
		//遍历第一行中的0
		for(int i = 1;i < matrix[0].length;i ++){
			//第一行中的第i个元素为0，则将第i列全部赋值为0
			if(matrix[0][i] == 0){
				for(int j = 1;j < matrix.length;j ++){
					matrix[j][i] = 0;
				}
			}
		}
		
		//如果开始第一行存在0
		if(firstRowIsZero){
			for(int i = 0;i < matrix[0].length;i ++){
				matrix[0][i] = 0;
			}
		}
		
		//如果开始第一列存在0
		if(firstColIsZero){
			for(int i = 0;i < matrix.length;i ++){
				matrix[i][0] = 0;
			}
		}
    }
}
