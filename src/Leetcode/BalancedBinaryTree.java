package Leetcode;

//���������ģ��ص㿴һ��
public class BalancedBinaryTree {
	//�ⷨ1
	public boolean isBalanced1(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int depthOfLeft = getDepth(root.left, 1);
        int depthOfRight = getDepth(root.right, 1);
        
        if(Math.abs(depthOfRight-depthOfLeft) > 1){
            return false;
        }else{
            return isBalanced1(root.left) && isBalanced1(root.right);
        }
    }
    
    private int getDepth(TreeNode tree, int currentDepth){
        if(tree == null){
            return currentDepth;
        }
        return Math.max(getDepth(tree.left, currentDepth + 1), 
                getDepth(tree.right, currentDepth + 1));
    }
    
    
	//�ⷨ2
	/**
	 * ����㷨�Ƚ����뵽���úÿ���
	 * time complexity O(N), space complexity O(logN).
	 * ��ÿ���ڵ��height��Ϣ��isBalanced��Ϣ�ںϵ�һ��������У�
	 * ����ñ���>=0����ô�ýڵ���balanced���Ҹñ������ǽڵ��height��
	 * ����ñ���<0����ô�ýڵ���unbalanced����ͬʱ����ʧȥ������height��Ϣ��
	 * @author MG
	 */
	public boolean isBalanced2(TreeNode root) {
        if(checkHeight(root) == -1){
        	return false;
        }
        else{
        	return true;
        }
    }
	
	private int checkHeight(TreeNode root){
		if(root == null){
            return 0;
        }
        
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        
        int heightDiff = leftHeight - rightHeight;
        
        if(Math.abs(heightDiff) > 1){
            return -1;
        }
        else{
        	//Ϊʲô����������
            return Math.max(leftHeight, rightHeight);
        }
	}
}
