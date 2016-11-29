package LeetCodeSecondMedium;

public class SpiralMatrixII59 {
	public int[][] generateMatrix(int n) {
		if(n <= 0) return new int[][]{};
		int top = 0, left = 0, down = n - 1, right = n - 1;
		
		int[][] res = new int[n][n];
		int element = 1;
		while(top <= down || left <= right) {
			for(int i = left; i <= right; i++) {
				res[left][i] = element ++;
			}
			
			for(int i = top + 1; i <= down; i++) {
				res[i][right] = element ++;
			}
			
			for(int i = right - 1; i >= left; i--) {
				res[down][i] = element ++;
			}
			
			for(int i = down - 1; i > top; i--) {
				res[i][left] = element ++;
			}
			
			left ++;
			top ++;
			right --;
			down --;
		}
		
		return res;
	}

}
