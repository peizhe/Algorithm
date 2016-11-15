package Leetcode;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
		TreeNode head = root;
		if(head == null){
			return null;
		}
        
        if(head.left == null && head.right == null){
        	return head;
        }
        exchange(head);
        
        invertTree(head.left);
    	invertTree(head.right);
    	
        return root;
    }
	
	public void exchange(TreeNode root){
		TreeNode temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}
