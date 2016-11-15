package Leetcode;
/**
 * �μǶ�����������������������������������ƽ����������
 * �����������Ͷ�����������һ���£���������ǵ���������
 * ����ƽ������ָÿһ���ڵ����������ĸ߶Ȳ����1
 */
import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
	
	List<Integer> ls = new ArrayList<Integer>();
	public int kthSmallest(TreeNode root, int k) {
		midOrder(root);
        return ls.get(k - 1);
    }
	
	//�������һ�飬�õ��������ǵ���������
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
