package LeetCodeSecondMedium;

import java.util.Stack;

import Structure.TreeNode;

/**
 * 思想 :
 * 	中序遍历前k个
 * 
 * @author MG
 *
 */
public class KthSmallestElementInABST230 {
	
	
	public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) {
        	return -1;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        while(k > 0 && (current != null || !stack.isEmpty())) {
        	while(current != null) {
        		stack.add(current);
        		current = current.left;
        	}
        	
        	current = stack.pop();
        	
        	if(--k == 0) return current.val;
        	
        	current = current.right;
        }
        
        return -1;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
