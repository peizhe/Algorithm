package Leetcode;

//这是一种写题的方法，记住，方法巧妙，只是复杂度有点高
public class MaximumDepthOfBinaryTree {

	int max = 0;

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return max;
		} else {
			deep(root, 1);
		}

		return max;
	}

	private void deep(TreeNode root, int depth) {
		if (root.left == null && root.right == null) {
			if (depth > max) {
				max = depth;
			}
		}
		if (root.left != null) {
			deep(root.left, depth + 1);
		}
		if (root.right != null) {
			deep(root.right, depth + 1);
		}
	}
}
