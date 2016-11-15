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
	 * �����������������ȫ���������ĸ��ڵ��±��� i����ô�����Һ��ӵ��±�ֱ�Ϊ 2*i + 1 �� 2*i + 2��
	 * 	�������ﲢ��һ������������������ȫ�������������������Ӧ��ϵ��Ҫ�����޸�
	 * 
	 * ֻ��Ҫ��¼ÿ���ڵ�ǰ�ж��ٸ� null �ڵ㣬�Ϳ����ҳ��ýڵ�ĺ����������ˣ������Һ��ӷֱ�Ϊ 2*(i-num) + 1 �� 2*(i-num) + 2 ��numΪ��ǰ�ڵ�֮ǰ null �ڵ�ĸ�������
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;

		String[] vals = data.split(",");
		int[] nums = new int[vals.length]; // �ڵ�i֮ǰnull�ڵ�ĸ���
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
