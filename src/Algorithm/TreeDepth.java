package Algorithm;


public class TreeDepth {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	//��������ȵ���򵥷�����ʵ��̫�����ˣ�
	//����˼���Ǵ����ĵײ���ʼ���Ͻ��е����������ĸ߶�
	public int treeDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		return (left > right) ? (left + 1) : (right + 1);
	}
}
