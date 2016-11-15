package Leetcode;

/**
 * �����Ĺؼ���������һ��ջ��
 * ���ջ�����洢������ڵ���ҽڵ�
 * �ҽڵ�����ջ����ڵ���ջ
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		if (root == null)
			return ls;
		//ѹ��root�ڵ�
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		
		//�ص������ѭ��
		while (!st.isEmpty()) {
			//ȡ��ջ���ڵ㣬�����б���
			TreeNode temp = st.pop();
			ls.add(temp.val);
			//�ҽڵ���ջ
			if (temp.right != null)
				st.push(temp.right);
			//��ڵ���ջ
			if (temp.left != null)
				st.push(temp.left);
		}
		return ls;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
