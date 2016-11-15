package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 构建哈弗曼树
 * 	一棵满二叉树(所有非叶子节点都有两个孩子)的中间节点比叶子节点少1个，总结点数是(2 * 叶子节点 - 1)
 * 
 * 	所以生成一个哈夫曼树需要生成n - 1个节点，所以必须循环n - 1次
 * @author MG
 *
 */
public class Huffman {
	public static TreeNode buildHuffmanTree(int[] frequency){
		PriorityQueue<TreeNode> pq = new PriorityQueue<TreeNode>(frequency.length, new Comparator<TreeNode>() {

			public int compare(TreeNode o1, TreeNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		
		for(int i : frequency){
			pq.offer(new TreeNode(i));
		}
		
		for(int i = 1;i < frequency.length;i ++){
			TreeNode root = new TreeNode(-1);
			
			root.right = pq.poll();
			root.left = pq.poll();
			
			root.val = root.left.val + root.right.val;
			
			pq.offer(root);
		}
		
		return pq.poll();
	}
	
	public static void main(String[] mh){
		int[] frequency = new int[]{2,3,1,6,5,4};
		TreeNode res = buildHuffmanTree(frequency);
		System.out.println(res.val);
	}
}
