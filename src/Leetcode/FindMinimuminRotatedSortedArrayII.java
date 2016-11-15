package Leetcode;

public class FindMinimuminRotatedSortedArrayII {
	
	int result = Integer.MAX_VALUE;
	public int findMin(int[] nums) {
		binarySearch(nums, 0, nums.length - 1);
        return result;
    }
	
	public void binarySearch(int[] nums,int left,int right){
		if(left > right){
			return;
		}
		if(nums[left] < nums[right]){
			if(nums[left] < result){
				result = nums[left];
			}
			return;
		}
		else{
			int mid = left + (right - left) / 2;
			if(nums[mid] < result){
				result = nums[mid];
			}
			
			binarySearch(nums, left, mid - 1);
			binarySearch(nums, mid + 1, right);
		}
	}
}
