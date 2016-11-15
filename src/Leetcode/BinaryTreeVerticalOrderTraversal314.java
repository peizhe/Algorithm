package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal314 {
	
	public static List<List<Integer>> verticalTravel(TreeNode root) {
		if(root == null) {
			return new ArrayList<List<Integer>>();
		}
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> index = new ArrayList<Integer>();
		
		helper(map, index, root, 0);
		
		Collections.sort(index);
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for(int i : index) {
			res.add(map.get(i));
		}
		
		return res;
	}
	
	
	private static void helper(Map<Integer, List<Integer>> map, List<Integer> index, TreeNode root, int level) {
		if(map.containsKey(level)) {
			map.get(level).add(root.val);
		} else {
			//map中不存在level时,将level存入index
			index.add(level);
			
			map.put(level, new ArrayList<Integer>());
			map.get(level).add(root.val);
		}
		
		if(root.left != null) {
			helper(map, index, root.left, level - 1);
		}
		
		if(root.right != null) {
			helper(map, index, root.right, level + 1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
