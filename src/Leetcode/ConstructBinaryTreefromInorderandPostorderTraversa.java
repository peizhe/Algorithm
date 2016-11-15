package Leetcode;

public class ConstructBinaryTreefromInorderandPostorderTraversa {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return assistBuildTree(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1);
    }
	
	public TreeNode assistBuildTree(int[] inorder,int ibegin,int iend,int[] postorder,int pbegin,int pend){
		
		if (pbegin > pend) {
			return null;
		}
		
		int povit = postorder[pend];
		
		//������������ҵ�povit��λ��
		int i = ibegin;
		for(;i <= iend;i ++){
			if(inorder[i] == povit){
				break;
			}
		}
		
		int rightLength = iend - i;
		TreeNode root = new TreeNode(povit);
		
		//�������������������������
		root.right = assistBuildTree(inorder, i + 1, iend, postorder, pend - rightLength, pend - 1);
		root.left = assistBuildTree(inorder, ibegin, i - 1, postorder, pbegin, pend - rightLength - 1);
		
		return root;
	}
}
