package Leetcode;

public class RangeSumQuery2DImmutable304 {
	int[][] sum;
	public RangeSumQuery2DImmutable304(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}
        int row = matrix.length;
        int col = matrix[0].length;
        
        sum = new int[row + 1][col + 1];
        
        for(int i = 1;i <= row;i ++){
        	for(int j = 1;j <= col;j ++){
        		sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum == null){
        	return 0;
        }
        
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = new int[][]{{1},{-7}};
		RangeSumQuery2DImmutable304 rs = new RangeSumQuery2DImmutable304(nums);
		System.out.println(rs.sumRegion(2,1,4,3));
	}

}
