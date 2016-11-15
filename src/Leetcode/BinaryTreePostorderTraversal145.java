package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
	public static List<Integer> postorderTraversal(TreeNode root) {
		if(root == null){
			return new ArrayList<Integer>();
		}
		
		List<Integer> res = new ArrayList<Integer>();
		List<TreeNode> temp = new LinkedList<TreeNode>(); 
		
		temp.add(root);
		
		while(!temp.isEmpty()){
			TreeNode first = temp.get(0);
			
			//���Ӳ�Ϊ�գ���ֱ�ӷ������
			if(first.left != null){
				temp.add(0, first.left);
				first.left = null;
				continue;
			}

			//����Ϊ�գ����ж��Һ���,���Һ��Ӳ�Ϊ�գ���ֱ�ӷ������
			if(first.right != null){
				temp.add(0, first.right);
				first.right = null;
				continue;
			}
			
			//����Ϊ�գ��Һ���ҲΪ��
			res.add(first.val);
			temp.remove(0);
		}
		
		return res;
    }	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node4;
		node2.right = node3;
		node4.left = node5;
		
		List<Integer> res = postorderTraversal(node1);
		for(int i : res){
			System.out.print(i + " ");
		}
	}	

}
