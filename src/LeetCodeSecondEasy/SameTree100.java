package LeetCodeSecondEasy;

import Structure.TreeNode;

public class SameTree100 {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        }
        
        if(p == null || q == null){
        	return false;
        }
        
        if(p.val != q.val){
        	return false; 
        }else{
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
