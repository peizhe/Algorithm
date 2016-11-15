package LeetCodeSecondEasy;

import Structure.TreeNode;


public class LowestCommoAncestorofaBinarySearchTree235 {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
        	return null;
        }
        
        if(p .val == root.val){
        	return p;
        }
        
        if(q.val == root.val){
        	return q;
        }
        
        if(q.val < root.val && p.val < root.val){
        	return lowestCommonAncestor(root.left, p, q);
        }
        else if(q.val > root.val && p.val > root.val){
        	return lowestCommonAncestor(root.right, p, q);
        }
        else{
        	return root;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
