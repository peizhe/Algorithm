package Leetcode;

/**
 * ��Ҫ������߼�
 * 
 * @author MG ���˵�˼�룺�����¶��ۣ����ضԽ��߶���(���������)
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		int step = len - 1;
		for (int i = 0; i < len / 2; i++) {
			// �ұ߽�����±߽�
			int rightLine = len - i - 1;
			// ��߽�
			int leftLine = i;
			for (int j = i; j < rightLine; j++) {

				// �͵�һ��������
				int col = j + step;
				int row = i;
				if (col > rightLine) {
					row = leftLine + col - rightLine;
					col = rightLine;
				}
				swap(matrix, i, j, row, col);

				// �͵ڶ���������
				row = row + step;
				if (row > rightLine) {
					col = rightLine - (row - rightLine);
					row = rightLine;
				}
				swap(matrix, i, j, row, col);

				// �͵�����������
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
