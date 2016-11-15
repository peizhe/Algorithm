package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一棵树是否为BST
 * 	1.中序遍历一次(判断遍历结果是否升序)
 * 	2.dfs(很经典的写法)
 * 
 * 
 * @author MG
 *
 */
public class ValidateBinarySearchTree98 {

	public boolean isValidBSTBetter(TreeNode root) {
	    return help(root, null, null);
	}
	
	private boolean help(TreeNode p, Integer low, Integer high) {
	    if (p == null) return true;
	    return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
	}
	
	
	List<Integer> res = new ArrayList<Integer>();
	
	public boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}
		
		inOrder(root);
		
		int size = res.size();
		for(int i = 1; i < size; i++){
			if(res.get(i) <= res.get(i - 1)) return false;
		}
		
		return true;
    }
	
	private void inOrder(TreeNode root){
		if(root.left != null){
			inOrder(root.left);
		}
		
		res.add(root.val);
		
		if(root.right != null){
			inOrder(root.right);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
