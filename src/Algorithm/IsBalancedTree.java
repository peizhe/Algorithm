package Algorithm;
/**
 * (理解树的深度的概念：从叶子节点到根节点的路径的节点数目)树的深度和高度差1，不要搞错
 * 思想：从底部开始遍历，同时比较左子树和右子树是否平衡，这样，不用重复遍历节点，每个节点只需要遍历一次
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