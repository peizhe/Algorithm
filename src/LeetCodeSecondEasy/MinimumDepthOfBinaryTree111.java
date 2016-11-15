package LeetCodeSecondEasy;

import Structure.TreeNode;

public class MinimumDepthOfBinaryTree111 {
	int minDepth = Integer.MAX_VALUE;
	
	public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        
        assistHelp(root, 1);
        
        return minDepth;
    }
	
	private void assistHelp(TreeNode root,int depth){
		if(root.left == null && root.right == null){
			minDepth = depth < minDepth ? depth : minDepth;
			return;
		}
		
		if(root.left != null){
			assistHelp(root.left, depth + 1);
		}
		
		if(root.right != null){
			assistHelp(root.right, depth + 1);
		}
	}
}
