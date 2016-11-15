package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

import Structure.TreeNode;
/**
 * 一棵树从右侧观察能看到节点
 * 	1.只是用一个存储结果的列表
 * @author MG
 *
 */
public class BinaryTreeRightSideView199 {

	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null){
			return list;
		}
		
		dfs(root, 0);
		
		return list;
	}
	
	private void dfs(TreeNode root, int level){
		if(list.size() <= level){
			list.add(root.val);
		}
		
		if(root.right != null){
			dfs(root.right,level + 1);
		} 
		
		if(root.left != null){
			dfs(root.left, level + 1);
		}
	}
}
