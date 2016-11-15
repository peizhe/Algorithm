package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ������������
 * 	һ����������(���з�Ҷ�ӽڵ㶼����������)���м�ڵ��Ҷ�ӽڵ���1�����ܽ������(2 * Ҷ�ӽڵ� - 1)
 * 
 * 	��������һ������������Ҫ����n - 1���ڵ㣬���Ա���ѭ��n - 1��
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
