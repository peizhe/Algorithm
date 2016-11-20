package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Structure.TreeNode;

/**
 * 操作树
 * 
 * @author MG
 *
 */
public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		
		//链表模拟队列
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
        	while(current != null) {
        		stack.add(current);
        		current = current.left;
        	}
        	
        	current = stack.pop();
        	res.add(current.val);
        	current = current.right;
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
