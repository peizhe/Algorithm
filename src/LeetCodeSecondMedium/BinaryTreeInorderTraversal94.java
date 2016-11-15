package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Structure.TreeNode;


public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		
		//链表模拟队列
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        
        TreeNode current = root;
        while(stack.size() > 0){
        	current = stack.peek();
        	root = current;
        	
        	if(current.left != null){
        		stack.add(current.left);
        		continue;
        	}
        	
        	res.add(current.val);
        	
        	if(current.right != null){
        		stack.add(current.right);
        		continue;
        	}
        	
        	stack.pop();
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
