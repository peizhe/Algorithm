package LeetCodeSecondMedium;

public class GameOfLife289 {
	public void gameOfLife(int[][] board) { 
		if(board == null || board.length == 0) return;
		
		int row = board.length, col = board[0].length;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int lives = calucateCount(board, i, j, row, col);
				if((board[i][j] == 1 && lives >= 2 && lives <= 3) || board[i][j] == 0 && lives == 3)
					board[i][j] += 2;
			}
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	private int calucateCount(int[][] board, int i, int j, int row, int col) {
		int sum = 0;
		for(int m = Math.max(i - 1, 0); m <= Math.min(i + 1, row - 1); m++) {
			for(int n = Math.max(j - 1, 0); n <= Math.min(j + 1, col - 1); n++) {
				sum += board[m][n] & 1;
			}
		}
		
		sum -= board[i][j] & 1;
		
		return sum;
	}
}
