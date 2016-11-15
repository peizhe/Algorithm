package LeetCodeSecondEasy;

import Structure.TreeNode;

public class BalancedBinaryTree110 {
	public boolean isBalanced(TreeNode root) {
	    if(checkHeight(root,1) == -1)
	        return false;
	    else 
	        return true;
	}
	
	private int checkHeight(TreeNode root,int currentHeight){
		if(root == null){
			return currentHeight - 1;
		}
		
		int leftHeight = checkHeight(root.left,currentHeight + 1);
		if(leftHeight == -1){
			return -1;
		}
		
		int rightHeight = checkHeight(root.right,currentHeight + 1);
		if(rightHeight == -1){
			return -1;
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1){
			return -1;
		}else{
			return leftHeight > rightHeight ? leftHeight : rightHeight;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
