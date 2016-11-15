package Leetcode;

public class PathSumIII437 {
	public int pathSum(TreeNode root, int sum) {
        if(root == null){
        	return 0;
        }
        
        return dfs(root, sum) + help(root, sum);
    }
	
	private int help(TreeNode root, int sum){
		if(root == null){
			return 0;
		}
		
		int leftCount = 0, rightCount = 0;

		//左子树中可以等于sum的数量
		leftCount = dfs(root.left, sum);
		//右子树中可以等于sum的数量
		rightCount = dfs(root.right, sum);
		
		return leftCount + rightCount + help(root.left, sum) + help(root.right, sum);
	}
	
	/**
	 * 计算从一个节点出发到所有子节点之和等于sum的个数
	 * 
	 * @param root
	 * @param currentVal
	 */
	private int dfs(TreeNode root, int currentVal){
		if(root == null){
			return 0;
		}
		
		return (currentVal == root.val ? 1 : 0) + dfs(root.left, currentVal - root.val) + dfs(root.right, currentVal - root.val);
	}
}
