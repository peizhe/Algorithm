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

	public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res ,0);
        
        return res;
    }
	
	private void helper(TreeNode root, List<Integer> res, int level) {
		if(res.size() == level) res.add(root.val);
		
		if(root.right != null) helper(root.right, res, level + 1);
		
		if(root.left != null) helper(root.left, res, level + 1);
	}
}
