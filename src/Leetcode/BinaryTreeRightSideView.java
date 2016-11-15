package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层次遍历的思想

public class BinaryTreeRightSideView {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return res;
		}

		Queue<TreeNode> pre = new LinkedList<TreeNode>();
		Queue<TreeNode> after = new LinkedList<TreeNode>();

		pre.add(root);

		while (!pre.isEmpty()) {
			TreeNode temp = pre.peek();
			res.add(temp.val);
			while (!pre.isEmpty()) {
				TreeNode t = pre.poll();
				if (t.right != null) {
					after.add(t.right);
				}
				
				if (t.left != null) {
					after.add(t.left);
				}
			}

			pre = after;
			after = new LinkedList<TreeNode>();
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}