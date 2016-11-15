package Algorithm;
/**
 * (���������ȵĸ����Ҷ�ӽڵ㵽���ڵ��·���Ľڵ���Ŀ)������Ⱥ͸߶Ȳ�1����Ҫ���
 * ˼�룺�ӵײ���ʼ������ͬʱ�Ƚ����������������Ƿ�ƽ�⣬�����������ظ������ڵ㣬ÿ���ڵ�ֻ��Ҫ����һ��
 * @author MG
 */
public class IsBalancedTree {
	
	public boolean isBalanced(TreeNode root) {
	    if(checkHeight(root) == -1)
	        return false;
	    else 
	        return true;
	}
	
	private int checkHeight(TreeNode root){
	    if(root == null)
	        return 0;

	    int leftHeight = checkHeight(root.left);
	    if(leftHeight == -1)
	        return -1;

	    int rightHeight = checkHeight(root.right);
	    if(rightHeight == -1)
	        return -1;

	    int heightDiff = leftHeight - rightHeight;
	    
	    if(Math.abs(heightDiff) > 1)
	        return -1;
	    else
	        return Math.max(leftHeight,rightHeight) + 1;
	}
	
	public static void main(String[] mh){
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		
		root.left = left;
		root.right = right;
		
		IsBalancedTree is = new IsBalancedTree();
		System.out.println(is.isBalanced(root));
	}
}