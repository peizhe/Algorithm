package Leetcode;

public class SumRoottoLeafNumbers {
	//´æ´¢×îÖÕ½á¹û
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.val;
		}
		
		
		iterate(root, root.val);
		return sum;
    }
	
	//µÝ¹éËÑË÷
	private void iterate(TreeNode root,int temp){
		if(root.left == null && root.right == null){
			sum = sum + temp;
			return;
		}
		
		if(root.left != null){
			iterate(root.left,temp * 10 + root.left.val);
		}
		
		if(root.right != null){
			iterate(root.right, temp * 10 + root.right.val);
		}
	}
}
