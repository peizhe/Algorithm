package Leetcode;

public class MinimumDepthOfBinaryTree {
	private int minDepth = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		getDepth(root, 1);

		return minDepth;
	}

	private void getDepth(TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			if (depth < minDepth) {
				minDepth = depth;
			}
		}
		if (root.left != null) {
			getDepth(root.left, depth + 1);
		}
		if (root.right != null) {
			getDepth(root.right, depth + 1);
		}
	}
}
