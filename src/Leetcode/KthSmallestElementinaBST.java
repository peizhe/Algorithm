package Leetcode;
/**
 * 牢记二叉树、二叉排序树、二叉搜索树、二叉平衡树的区别
 * 二叉排序树和二叉搜索树是一回事：中序遍历是单调递增的
 * 二叉平衡树：指每一个节点左右子树的高度差不超过1
 */
import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
	
	List<Integer> ls = new ArrayList<Integer>();
	public int kthSmallest(TreeNode root, int k) {
		midOrder(root);
        return ls.get(k - 1);
    }
	
	//中序遍历一遍，得到的序列是单调递增的
	private void midOrder(TreeNode root){
		if(root.left == null && root.right == null){
			ls.add(root.val);
			return;
		}
		
		if(root.left != null){
			midOrder(root.left);
		}
		
		ls.add(root.val);
		
		if(root.right != null){
			midOrder(root.right);
		}
	}
}
