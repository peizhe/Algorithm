package LeetCodeSecondMedium;

import Structure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1){
        	return null;
        }
        
        return produceTree(nums, 0, nums.length - 1);
    }
	
	private TreeNode produceTree(int[] nums, int begin, int end) {
		if(begin >= end) return new TreeNode(nums[begin]);
		
		int mid = begin + ((end - begin) >> 1);
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = produceTree(nums, begin, mid - 1);
		root.right = produceTree(nums, mid + 1, end);
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
