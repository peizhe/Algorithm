package Algorithm;


public class TreeDepth {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	//求树的深度的最简单方法（实在太精炼了）
	//它的思想是从树的底部开始向上进行迭代计算树的高度
	public int treeDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		
		return (left > right) ? (left + 1) : (right + 1);
	}
}
