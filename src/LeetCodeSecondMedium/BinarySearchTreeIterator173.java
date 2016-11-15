package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Structure.TreeNode;

public class BinarySearchTreeIterator173 {
	
	List<Integer> res = new ArrayList<Integer>();
	Iterator<Integer> iterator;
	public BinarySearchTreeIterator173(TreeNode root) {
		dfs(root);
		iterator = res.iterator();
    }
	
	private void dfs(TreeNode root){
		if(root == null){
			return;
		}
		
		dfs(root.left);
		res.add(root.val);
		dfs(root.right);
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return iterator.hasNext();
    }

    /** @return the next smallest number */
    public int next() {    	
    	return iterator.next();
    }
}
