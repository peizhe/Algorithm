package Leetcode;

import java.util.ArrayList;
import java.util.List;
//�����ȽϺã����Ǹ��Ӷ��е�ߣ��úÿ���
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
