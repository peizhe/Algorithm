package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Structure.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        
        boolean l2t = true;
        
        while(!current.isEmpty()) {
        	TreeNode node = current.poll();
        	
        	if(l2t) temp.add(node.val);
        	else temp.add(0, node.val);
        	
        	
        	if(node.left != null) next.add(node.left);
        	if(node.right != null) next.add(node.right);
        	
        	if(current.isEmpty()) {
        		res.add(new LinkedList<Integer>(temp));
        		temp.clear();
        		
        		current.addAll(next);
        		next.clear();
        		//方向取反
        		l2t = !l2t;
        	}
        }
        
        return res;
    }
}
