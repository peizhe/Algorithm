package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

import Structure.TreeNode;
/**
 * һ�������Ҳ�۲��ܿ����ڵ�
 * 	1.ֻ����һ���洢������б�
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
