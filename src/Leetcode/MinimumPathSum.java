package Leetcode;

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		if(grid.length == 1){
			int result = 0;
			for(int i = 0;i < grid[0].length;i ++){
				result = result + grid[0][i];
			}
			return result;
		}
		if(grid[0].length == 1){
			int result = 0;
			for(int i = 0;i < grid.length;i ++){
				result = result + grid[i][0];
			}
			return result;
		}
		
		int rowLength = grid.length,colLength = grid[0].length;
		
		int[][] distance = new int[rowLength][colLength];
		distance[0][0] = grid[0][0];
		
		for(int i = 1;i < colLength;i ++){
			distance[i][0] = distance[i - 1][0] + grid[i][0];
		}
		
		for(int i = 1;i < rowLength;i ++){
			distance[0][i] = distance[0][i - 1] + grid[0][i];
		}
		
		for(int i = 1;i < rowLength;i ++){
			for(int j = 1;j < colLength;j ++){
				distance[i][j] = Math.min(distance[i - 1][j] + grid[i][j], distance[i][j - 1] + grid[i][j]);
			}
		}
		
		return distance[rowLength - 1][colLength - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
