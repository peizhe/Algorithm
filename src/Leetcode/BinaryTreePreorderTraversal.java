package Leetcode;

/**
 * 这道题的关键在于运用一个栈！
 * 这个栈用来存储树的左节点和右节点
 * 右节点先入栈，左节点入栈
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		if (root == null)
			return ls;
		//压入root节点
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		
		//重点在这个循环
		while (!st.isEmpty()) {
			//取出栈顶节点，加入列表中
			TreeNode temp = st.pop();
			ls.add(temp.val);
			//右节点入栈
			if (temp.right != null)
				st.push(temp.right);
			//左节点入栈
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
