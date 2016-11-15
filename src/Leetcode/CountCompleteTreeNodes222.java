package Leetcode;

/**
 * 传统的方法超时
 * 
 * @author MG
 * 
 */
public class CountCompleteTreeNodes222 {
	private int height(TreeNode root) {
		return root == null ? 0 : 1 + height(root.left);
	}

	public int countNodes(TreeNode root) {
		int h = height(root);
		if (h == 0)
			return 0;
		
		return height(root.right) == h - 1 ? (1 << h - 1) + countNodes(root.right) : (1 << h - 2) + countNodes(root.left);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
