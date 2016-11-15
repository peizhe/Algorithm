package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题 1.回溯法 2.位操作
 * 
 * @author MG
 * 
 */
public class NQueens51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> nQueens = new ArrayList<List<String>>();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++)
			str.append('.');
		backtrack(nQueens, new ArrayList<String>(), str, new boolean[n],
				new boolean[2 * n], new boolean[2 * n], 0, n);
		return nQueens;
	}

	public void backtrack(List<List<String>> nQueens, List<String> currQueens,
			StringBuilder str, boolean[] cols, boolean[] diag1,
			boolean[] diag2, int row, int size) {
		if (row == size) {
			nQueens.add(new ArrayList<String>(currQueens));
			return;
		}

		for (int i = 0; i < size; i++) {
			int i1 = row + i;
			int i2 = i - row + size - 1;
			if (!cols[i] && !diag1[i1] && !diag2[i2]) {
				cols[i] = true;
				diag1[i1] = true;
				diag2[i2] = true;
				str.setCharAt(i, 'Q');
				currQueens.add(str.toString());
				str.setCharAt(i, '.');
				
				backtrack(nQueens, currQueens, str, cols, diag1, diag2, row + 1, size);
				
				currQueens.remove(currQueens.size() - 1);
				cols[i] = false;
				diag1[i1] = false;
				diag2[i2] = false;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
