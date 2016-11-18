package LeetCodeSecondMedium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix378 {

	static class Node {
		int row;
		int col;

		int val;

		public Node(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public static int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || k <= 0) {
			return -1;
		}

		PriorityQueue<Node> queue = new PriorityQueue<Node>(k,
				new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						return o1.val - o2.val;
					}
				});

		int row = matrix.length, col = matrix[0].length;
		for(int i = 0; i < col; i++) {
			queue.add(new Node(0, i, matrix[0][i]));
		}

		for(int i = 0; i < k - 1; i++) {
			Node peek = queue.poll();
			if(peek.row == row - 1) continue;
			
			queue.add(new Node(peek.row + 1, peek.col, matrix[peek.row + 1][peek.col]));
		}

		return queue.poll().val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
		int x = 8;
		System.out.println(kthSmallest(nums, x));
	}

}
