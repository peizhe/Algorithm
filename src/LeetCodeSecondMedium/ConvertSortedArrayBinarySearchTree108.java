package LeetCodeSecondMedium;

import Structure.TreeNode;

public class ConvertSortedArrayBinarySearchTree108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length < 1){
        	return null;
        }
        
        return produceTree(nums, 0, nums.length - 1);
    }
	
	private TreeNode produceTree(int[] nums, int begin, int end){
		if(begin <= end){
			int mid = begin + (end - begin) / 2;
			TreeNode root = new TreeNode(nums[mid]);
			
			root.left = produceTree(nums, begin, mid - 1);
			root.right = produceTree(nums, mid + 1, end);
			
			return root;
		}
		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
