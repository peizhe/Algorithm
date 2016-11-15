package Leetcode;

public class PathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;	
		}
		
		if(root.left == null && root.right == null){
			return root.val == sum;
		}
		if(root.left != null){
			root.left.val = root.left.val + root.val;
		}
		if(root.right != null){
			root.right.val = root.right.val + root.val;
		}
		
		return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }
}

