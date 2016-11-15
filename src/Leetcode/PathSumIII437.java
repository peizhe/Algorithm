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

		//�������п��Ե���sum������
		leftCount = dfs(root.left, sum);
		//�������п��Ե���sum������
		rightCount = dfs(root.right, sum);
		
		return leftCount + rightCount + help(root.left, sum) + help(root.right, sum);
	}
	
	/**
	 * �����һ���ڵ�����������ӽڵ�֮�͵���sum�ĸ���
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
