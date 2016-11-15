package Leetcode;

public class LowestCommonAncestorOfaBinarySearchTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val < root.val && root.val < q.val){
			return root;
		}
		else if(p.val == root.val){
			return p;
		}
		else if(q.val == root.val){
			return q;
		}
		else if(p.val < root.val && q.val < root.val){
			return lowestCommonAncestor(root.left, p, q);
		}
		else if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestor(root.right, p, q);
		}
		else{
			return root;
		}
    }
}
