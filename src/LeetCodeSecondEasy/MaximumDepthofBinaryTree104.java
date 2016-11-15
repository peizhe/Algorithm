package LeetCodeSecondEasy;

import Structure.TreeNode;

/**
 * 计算树的最大深度：
 * 	1.递归的方法：代码简单
 *  2.循环的方法：使用双队列(树的层次遍历类似)
 * @author MG
 *
 */
public class MaximumDepthofBinaryTree104 {
	
	private int depth = 0;
	
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
        
		depth(root,1);
		
        return depth;
    }
	
	private void depth(TreeNode root, int tempDepth){
		if(root.left == null && root.right == null){
			if(tempDepth > depth){
				depth = tempDepth;
			}
		}
		if(root.left != null){
			depth(root.left,tempDepth + 1);
		}
		if(root.right != null){
			depth(root.right,tempDepth + 1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
