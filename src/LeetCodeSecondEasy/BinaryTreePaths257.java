package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

import Structure.TreeNode;

public class BinaryTreePaths257 {
	List<String> res = new ArrayList<String>();
	
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null){
			return res;
		}
		
		assistHelp(root, "");
		return res;
    }	
	
	private void assistHelp(TreeNode root,String temp){
		temp += root.val;
		if(root.left == null && root.right == null){
			res.add(temp);
			return;
		}
		
		if(root.left != null){
			assistHelp(root.left, temp + "->");
		}
		
		if(root.right != null){
			assistHelp(root.right, temp + "->");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode next = new TreeNode(3);
		
		root.left = left;
		root.right = right;
		left.right = next;
		
		BinaryTreePaths257 x = new BinaryTreePaths257();
		x.binaryTreePaths(root);
		
		for(String s : x.res){
			System.out.println(s);
		}
	}
}
