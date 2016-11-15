package LeetCodeSecondEasy;

import Structure.TreeNode;

public class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        
        return assistHelp(root, 0, sum);
    }
	
	private boolean assistHelp(TreeNode root,int temp,int des){
		
		temp += root.val;
		
		if(root.left == null && root.right == null){
			if(temp == des){
				return true;
			}else{
				temp -= root.val;
			}
		}
	
		
		boolean left = false,right = false;
		if(root.left != null){
			left = assistHelp(root.left, temp, des);
		}
		
		if(root.right != null){
			right = assistHelp(root.right, temp, des);
		}
		
		return left || right;
	}
}
