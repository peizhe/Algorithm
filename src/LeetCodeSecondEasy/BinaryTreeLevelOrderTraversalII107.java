package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Structure.TreeNode;
/**
 * 为什么就不对呢？
 * @author MG
 *
 */
public class BinaryTreeLevelOrderTraversalII107 {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null){
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		
		Stack<List<Integer>> res = new Stack<List<Integer>>();
		
        Queue<TreeNode> top = new LinkedList<TreeNode>();
        Queue<TreeNode> below = new LinkedList<TreeNode>();
        
        top.add(root);
        
        while(!top.isEmpty()){
        	TreeNode currentTop = top.remove();
        	temp.add(currentTop.val);
        	
        	if(currentTop.left != null){
        		below.add(currentTop.left);
        	}
        	
        	if(currentTop.right != null){
        		below.add(currentTop.right);
        	}
        	
        	if(top.isEmpty()){
        		res.push(new ArrayList<Integer>(temp));
        		temp.clear();
        		top.addAll(below);
        		below.clear();
        	}
        }
        
        while(!res.isEmpty()){
        	result.add(res.pop());
        }
        
        return result;
    }

	public List<List<Integer>> levelOrderBottom1(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    travelTree(0, root, result);
	    List<List<Integer>> reverseRst = new ArrayList<List<Integer>>();
	    for (int i = 0; i < result.size(); i++) {
	        reverseRst.add(result.get(result.size() - i - 1));
	    }
	    return reverseRst;
	}

	private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
	    if (root == null) 
	    	return;
	    if (result.size() <= level) 
	    	result.add(new ArrayList<Integer>());
	    result.get(level).add(root.val);
	    travelTree(level + 1, root.left, result);
	    travelTree(level + 1, root.right, result);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		levelOrderBottom(root);
	}

}
