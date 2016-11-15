package LeetCodeSecondEasy;

import Structure.TreeNode;

public class InvertBinaryTree226 {
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null){
        	return null;
        }
        
        TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
        
        return root;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
