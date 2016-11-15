package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

import Structure.TreeNode;

public class BinaryTreeLevelOrderTraversal102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
        	return res;
        }
        
        assistHelp(root, 0, res);
        return res;
    }
	
	private void assistHelp(TreeNode root,int height,List<List<Integer>> res){
		if(root == null){
			return;
		}
		
		if(res.size() <= height){
			res.add(new ArrayList<Integer>());
		}
		
		res.get(height).add(root.val);
		assistHelp(root.left, height + 1, res);
		assistHelp(root.right, height + 1, res);
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
