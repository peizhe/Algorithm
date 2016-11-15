package Leetcode;

/**
 * ����㷨�þ��裬Ϊɶ�Լ�û�뵽������
 * �ڵ�a��ڵ�b�Ĺ�������cһ�����㣺
 * a��b�ֱ������c�����������ϣ����a����b���������ȵĻ�����
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
