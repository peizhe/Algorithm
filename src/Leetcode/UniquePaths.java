package Leetcode;

public class UniquePaths {
	
	public static int uniquePaths(int m, int n) {
		if(m < 1 || n < 1){
			return 0;
		}
		
		int[][] count = new int[m][n];
		for(int i = 0;i < m;i ++){
			count[i][0] = 1;
		}
		
		for(int i = 0;i < n;i ++){
			count[0][i] = 1;
		}
		
		for(int i = 1;i < m;i ++){
			for(int j = 1;j < n;j ++){
				count[i][j] = count[i][j - 1] + count[i - 1][j];
			}
		}
		
        return count[m - 1][n - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3,y = 5;
		System.out.println(uniquePaths(x, y));
	}
}
