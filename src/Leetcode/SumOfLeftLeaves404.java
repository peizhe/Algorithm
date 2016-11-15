package Leetcode;

public class SumOfLeftLeaves404 {
	int sum = 0;
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        help(root, false);
        
        return sum;
    }
	
	private void help(TreeNode root, boolean isLeft) {
		if(root.left == null && root.right == null && isLeft){
			sum += root.val;
			return;
		}
		
		if(root.left != null){
			help(root.left, true);
		}
		
		if(root.right != null){
			help(root.right, false);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
