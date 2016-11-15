package Leetcode;

import java.util.ArrayList;
import java.util.List;
//方法比较好，但是复杂度有点高，好好看看
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	static List<String> result = new ArrayList<String>();
	
	public static List<String> binaryTreePaths(TreeNode root) {
		if(root != null){
			findPath(root, String.valueOf(root.val));
		}	
		return result;
    }
	
	private static void findPath(TreeNode root,String path){
		if(root.left == null && root.right == null){
			result.add(path);
		}
		if(root.left != null){
			findPath(root.left,path + "->" + root.left.val);
		}
		if(root.right != null){
			findPath(root.right,path + "->" + root.right.val);
		}
	}
}
