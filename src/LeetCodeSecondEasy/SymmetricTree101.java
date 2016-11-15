package LeetCodeSecondEasy;

import Structure.TreeNode;

/**
 * �ж�һ�����Ƿ��ǶԳ�����
 * 	1.(�ݹ�ķ���)�ݹ���ж�������������������������������   �������������������������������Ƿ�ֵ���
 * 	2.(ѭ���ķ���)��α������ж�ÿһ���Ԫ����Ŀ�Ƿ�Ϊ2^n(nΪ����)���Լ�ÿһ��Ԫ���Ƿ�Գ�
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
