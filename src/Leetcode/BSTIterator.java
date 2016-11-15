package Leetcode;
import java.util.Stack;

public class BSTIterator {

	Stack<Integer> data = new Stack<Integer>();
	public BSTIterator(TreeNode root) {
		helpFunction(root);
	}
	
	
	private void helpFunction(TreeNode root){
		if(root == null){
			return;
		}
		
		if(root.right != null){
			helpFunction(root.right);
		}
		
		data.push(root.val);
		
		if(root.left != null){
			helpFunction(root.left);
		}
	}
	
	
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return data.size() != 0;
	}

	/** @return the next smallest number */
	public int next() {
		return data.pop();
	}
}
