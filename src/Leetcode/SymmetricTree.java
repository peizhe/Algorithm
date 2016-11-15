package Leetcode;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		
        if(root == null){
        	return true;
        }
        return compare(root.left, root.right);
    }
	
	//���õݹ�ķ�ʽ�Ƚ���������������
	public boolean compare(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		else if (left != null && right != null){
			if(left.val == right.val){
				return compare(left.left,right.right) && compare(left.right,right.left);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}
