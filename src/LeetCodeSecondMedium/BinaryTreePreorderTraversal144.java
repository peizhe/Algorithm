package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Structure.TreeNode;

public class BinaryTreePreorderTraversal144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode temp;
        while(stack.size() > 0){
        	temp = stack.pop();
        	res.add(temp.val);
        	
        	if(temp.right != null){
        		stack.push(temp.right);
        	}
        	
        	if(temp.left != null){
        		stack.push(temp.left);
        	}
        }
        
        return res;
    }
}
