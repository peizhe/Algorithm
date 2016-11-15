package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree297 {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				sb.append("null,");
			} else {
				sb.append(node.val + ",");
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}

		return sb.toString();
	}

	/**
	 * 如果满二叉树（或完全二叉树）的父节点下标是 i，那么其左右孩子的下标分别为 2*i + 1 和 2*i + 2，
	 * 	但是这里并不一定是满二叉树（或完全二叉树），所以这个对应关系需要稍作修改
	 * 
	 * 只需要记录每个节点前有多少个 null 节点，就可以找出该节点的孩子在哪里了，其左右孩子分别为 2*(i-num) + 1 和 2*(i-num) + 2 （num为当前节点之前 null 节点的个数）。
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;

		String[] vals = data.split(",");
		int[] nums = new int[vals.length]; // 节点i之前null节点的个数
		TreeNode[] nodes = new TreeNode[vals.length];

		for (int i = 0; i < vals.length; i++) {
			if (i > 0) {
				nums[i] = nums[i - 1];
			}
			if (vals[i].equals("null")) {
				nodes[i] = null;
				nums[i] ++;
			} else {
				nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
			}
		}

		for (int i = 0; i < vals.length; i++) {
			if (nodes[i] == null) {
				continue;
			}
			nodes[i].left = nodes[2 * (i - nums[i]) + 1];
			nodes[i].right = nodes[2 * (i - nums[i]) + 2];
		}

		return nodes[0];
	}
}
