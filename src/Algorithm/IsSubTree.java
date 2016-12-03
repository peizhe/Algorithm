package Algorithm;

import Structure.TreeNode;
/**
 * �ж���A���Ƿ����������B�����˽ṹ��ȫ��ͬ
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
