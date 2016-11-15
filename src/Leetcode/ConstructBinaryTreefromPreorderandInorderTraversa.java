package Leetcode;
//����ǰ�����������������ָ�һ����
public class ConstructBinaryTreefromPreorderandInorderTraversa {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || preorder.length != inorder.length){
			return null;
		}
		
		return assistBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		
    }
	
	public TreeNode assistBuildTree(int[] preorder,int pbegin,int pend,int[] inorder,int ibegin,int iend){
		if(pbegin > pend){
			return null;
		}
		
		int pivot = preorder[pbegin];
		int i = ibegin;
		//����pivot����������е�λ��
		for(;i < iend;i ++){
			if(inorder[i] == pivot){
				break;
			}
		}
		
		int leftLength = i - ibegin;
		
		TreeNode root = new TreeNode(pivot);
		//����Ŀ�ʼ�±�ͽ����±����Ҫ
		root.left = assistBuildTree(preorder, pbegin + 1, pbegin + leftLength, inorder, ibegin, i - 1);
		root.right = assistBuildTree(preorder, pbegin + leftLength + 1, pend, inorder, i + 1, iend);
		
		
		return root;
	}
}
