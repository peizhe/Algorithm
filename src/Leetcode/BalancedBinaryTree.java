package Leetcode;

//不会这样的，重点看一下
public class BalancedBinaryTree {
	//解法1
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
    
    
	//解法2
	/**
	 * 这个算法比较难想到，好好看看
	 * time complexity O(N), space complexity O(logN).
	 * 把每个节点的height信息和isBalanced信息融合到一起个变量中：
	 * 如果该变量>=0，那么该节点是balanced并且该变量就是节点的height；
	 * 如果该变量<0，那么该节点是unbalanced，但同时我们失去了它的height信息。
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
        	//为什么这样返回呢
            return Math.max(leftHeight, rightHeight);
        }
	}
}
