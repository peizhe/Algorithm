package LeetCodeSecondMedium;

public class KthLargestElementInAnArray215 {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) return -1;
        
        return quickSort(nums, 0, nums.length - 1, k);
    }
	
	private int quickSort(int[] nums, int begin, int end, int k) {
		int left = begin, right = end, key = nums[begin];
        while(left < right) {
        	while(left < right && nums[right] <= key) {
        		right --;
        	}
        	
        	if(left < right) nums[left ++] = nums[right];
        	
        	while(left < right && nums[left] >= key) {
        		left ++;
        	}
        	
        	if(left < right) nums[right --] = nums[left];
        }
        
        nums[left] = key;
        
        if(left == k) {
        	return nums[left];
        } else if(left < k) {
        	return quickSort(nums, left + 1, end, k);
        } else {
        	return quickSort(nums, begin, left - 1, k);
        }
	}
}
