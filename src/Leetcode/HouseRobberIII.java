package Leetcode;

//dfs���
public class HouseRobberIII {
	
	public int rob(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int[] res = robHelp(root);
		
		return Math.max(res[0], res[1]);
    }
	
	
	/**
	 * dfs all the nodes of the tree, each node return two number, int[] num, 
	 * num[0] is the max value while rob this node, 
	 * num[1] is max value while not rob this value. 
	 * Current node return value only depend on its children's value. 
	 * Transform function should be very easy to understand.
	 * @param root
	 * @return
	 */
	public int[] robHelp(TreeNode root){
		if(root == null){
			return new int[2];
		}
		
		int[] left = robHelp(root.left);
		int[] right = robHelp(root.right);
		
		int[] res = new int[2];
		res[0] = left[1] + right[1] + root.val;
		//���������max���ǱȽϾ���ģ������Ϊʲô����(left[0] ��һ����left[1]��)
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return res;
	}
}
