package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
	
	/**
	 * ·ÖÖÎ·¨
	 * 
	 * @param n
	 * @return
	 */
	public static List<TreeNode> generateTrees(int n) {
		if (n < 1) {
			return new ArrayList<TreeNode>();
		}

		return helper(1, n);
	}

	private static List<TreeNode> helper(int begin, int end) {
		List<TreeNode> res = new LinkedList<TreeNode>();

		if (begin > end) {
			res.add(null);
			return res;
		}
		
		for (int i = begin; i <= end; i++) {
			List<TreeNode> left = helper(begin, i - 1);
			List<TreeNode> right = helper(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);

					root.left = l;
					root.right = r;

					res.add(root);
				}
			}
		}

		return res;
	}
	
	public static void main(String[] mh){
		generateTrees(2);
	}
}
