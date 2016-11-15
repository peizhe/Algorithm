package Leetcode;
/**
 * ���������ת��
 * 
 * @author MG
 *
 */
public class FlattenBinaryTreeToLinkedList114 {
	
	public void flatten(TreeNode root) {
		if(root == null){
			return;
		}
		
		leftToRight(root);
		
		helper(root);
    }
	
	private TreeNode helper(TreeNode root){
		if(root.left == null && root.right == null){
			return root;
		}
		
		TreeNode left = null,right = null;
		if(root.left != null){
			left = helper(root.left);
		}
		
		if(root.right != null){
			right = helper(root.right);
		}
		
		if(right == null){//����ҽڵ�Ϊ�գ���ֱ�ӽ���ڵ�����ҽڵ�
			root.right = left;
		} else {//����ҽڵ㲻Ϊ�գ�����ҪѰ�����һ���ҽڵ�
			TreeNode temp = root;
			while(temp.right != null){
				temp = temp.right;
			}
			
			temp.right = left;
		}
		
		root.left = null;
		
		return root;
	}
	
	
	/**
	 * �������������ֽ��жԻ�
	 *	
	 * @param root
	 */
	private void leftToRight(TreeNode root){
		if(root == null){
			return;
		}

		swap(root);
		
		leftToRight(root.left);
		leftToRight(root.right);
	}
	
	private void swap(TreeNode root){
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreeToLinkedList114 fb = new FlattenBinaryTreeToLinkedList114();
		
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		
		fb.flatten(root);
	}

}
