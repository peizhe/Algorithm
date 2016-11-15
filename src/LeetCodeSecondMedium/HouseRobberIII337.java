package LeetCodeSecondMedium;

import Structure.TreeNode;

public class HouseRobberIII337 {
	public static int rob(TreeNode root) {
		if(root == null){
			return 0;
		}
		int[] res = help(root);
		
		return Math.max(res[0], res[1]);
    }
	
	private static int[] help(TreeNode root){
		if(root == null){
			return new int[2];
		}
		int[] leftVal = help(root.left);
		int[] rightVal = help(root.right);

		int[] res = new int[2];
		//采集该节点的最大值
		res[0] = leftVal[1] + rightVal[1] + root.val;
		//不采集该节点的最大值
		res[1] = Math.max(leftVal[0], leftVal[1]) + Math.max(rightVal[0], rightVal[1]);
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode leftRight = new TreeNode(3);
		TreeNode rightLeft = new TreeNode(1);
		root.left = left;
		root.right = right;
		left.right = leftRight;
		right.left = rightLeft;
		
		System.out.println(rob(root));
	}
}
