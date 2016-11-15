package HihoCoder;

import java.util.*;

import Structure.TreeNode;
/**
 * 
 * 二叉树的垂直遍历
 * 	1.对于一个二叉树，输出它的垂直遍历结果；对于同一列的节点，按照从左向右，从上向下的顺序排列。
 * 
 * @author MG
 *
 */
public class BinaryTreeVerticalTravel {
	
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
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(6);
		right.left = node1;
		right.right = node2;
		node1.left = node3;
		
		List<List<Integer>> res = verticalTravel(root);
		for(List<Integer> list : res) {
			for(Integer j : list) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
}


