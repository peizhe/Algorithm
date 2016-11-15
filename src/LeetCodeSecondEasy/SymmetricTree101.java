package LeetCodeSecondEasy;

import Structure.TreeNode;

/**
 * 判断一棵树是否是对称树：
 * 	1.(递归的方法)递归的判断左子树的左子树和右子树的右子树   左子树的右子树和右子树的左子树是否值相等
 * 	2.(循环的方法)层次遍历，判断每一层的元素数目是否为2^n(n为层数)，以及每一层元素是否对称
 * @author MG
 *
 */
public class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        
		return symmetric(root.left, root.right);
    }
	
	private boolean symmetric(TreeNode left,TreeNode right){
		if(left == null && right == null){
        	return true;
        }
		
		if(left == null || right == null){
			return false;
		}
		
		if(left.val == right.val){
			return symmetric(left.right, right.left) && symmetric(left.left, right.right);
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
