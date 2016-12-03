package Algorithm;

import Structure.TreeNode;
/**
 * 判断树A中是否存在子树和B的拓扑结构完全相同
 * 
 * @author MG
 *
 */
public class IsSubTree {
	public static boolean isSubTree(TreeNode A, TreeNode B) {
		if(B == null) return true; 
		if(A == null) return false;
		
		if(A.val == B.val && isMatch(A, B)) return true;
		
		return isSubTree(A.left, B) || isSubTree(A.right, B);
	}
	
	private static boolean isMatch(TreeNode A, TreeNode B) {
		if(A== null && B == null) return true;
		if(A == null || B == null) return false;
		if(A.val != B.val) return false;
		
		return isMatch(A.left, B.left) && isMatch(A.right, B.right);
	}
}
