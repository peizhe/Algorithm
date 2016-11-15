package Leetcode;

/**
 * 这个算法好精髓，为啥自己没想到！！！
 * 节点a与节点b的公共祖先c一定满足：
 * a与b分别出现在c的左右子树上（如果a或者b本身不是祖先的话）。
 */
public class ImportantLowestCommonAncestorofaBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode L = lowestCommonAncestor(root.left, p, q);
		TreeNode R = lowestCommonAncestor(root.right, p, q);
		
		if (L != null && R != null)
			return root;
		return L != null ? L : R;
	}
}
