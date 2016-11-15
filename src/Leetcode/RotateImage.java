package Leetcode;

/**
 * 主要搞清楚逻辑
 * 
 * @author MG 别人的思想：将上下对折，再沿对角线对折(还是这个简单)
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int step = len - 1;
		for (int i = 0; i < len / 2; i++) {
			// 右边界或者下边界
			int rightLine = len - i - 1;
			// 左边界
			int leftLine = i;
			for (int j = i; j < rightLine; j++) {

				// 和第一个数交换
				int col = j + step;
				int row = i;
				if (col > rightLine) {
					row = leftLine + col - rightLine;
					col = rightLine;
				}
				swap(matrix, i, j, row, col);

				// 和第二个数交换
				row = row + step;
				if (row > rightLine) {
					col = rightLine - (row - rightLine);
					row = rightLine;
				}
				swap(matrix, i, j, row, col);

				// 和第三个数交换
				col = col - step;
				if (col < leftLine) {
					row = rightLine - (leftLine - col);
					col = leftLine;
				}
				swap(matrix, i, j, row, col);
			}
			step = step - 2;
		}
	}

	private void swap(int[][] a, int i, int j, int row, int col) {
		int temp = a[i][j];
		a[i][j] = a[row][col];
		a[row][col] = temp;
	}
}
