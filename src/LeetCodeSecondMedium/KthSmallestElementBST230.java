package LeetCodeSecondMedium;

import Structure.TreeNode;


/**
 * 寻找二分查找树中第K小的数：
 * 	1.中序遍历存储元素，直接取第K个
 * 	2.中序遍历，不存储元素，当K减为0时，取出那个元素
 * 	3.二分查找(如下，最完美)
 * 
 * 	搞清把变量声明为静态变量和作为参数传递到递归过程的不同！
 * @author MG
 *
 */
public class KthSmallestElementBST230 {
	
	private static int number = 0;
    private static int count = 0;

    public static int kthSmallestSecond(TreeNode root, int k) {
    	if(root == null){
    		return -1;
    	}
    	count = k;
        helper(root);
        return number;
    }
    
    public static void helper(TreeNode n) {
    	if(count > 0){
    		if (n.left != null) helper(n.left);
            
            count --;
            if (count == 0) {
                number = n.val;
                return;
            }
            
            if (n.right != null) helper(n.right);
    	}
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		root.left = left;
		System.out.println(kthSmallestSecond(root,1));
	}
	
	public int kthSmallestThird(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k < count + 1) {
            return kthSmallestThird(root.left, k);
        } else if (k > count + 1) {
            return kthSmallestThird(root.right, k - 1 - count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
