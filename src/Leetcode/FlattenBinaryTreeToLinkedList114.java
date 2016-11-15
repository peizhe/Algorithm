package Leetcode;
/**
 * 树与链表的转换
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
		
		if(right == null){//如果右节点为空，则直接将左节点放在右节点
			root.right = left;
		} else {//如果右节点不为空，则需要寻找最后一个右节点
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
	 * 将数左右两部分进行对换
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
