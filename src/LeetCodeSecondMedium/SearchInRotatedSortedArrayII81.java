package LeetCodeSecondMedium;
/**
 * 同样还是二分查找，需要加判断条件
 * 
 * @author MG
 *
 */
public class SearchInRotatedSortedArrayII81 {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        
        return helper(nums, 0, nums.length - 1, target);
    }
	
	private boolean helper(int[] nums, int begin, int end, int target) {
		if(begin > end) return false;
		if(nums[begin] < nums[end] && (nums[begin] > target || nums[end] < target)) return false;
		
		int mid = begin + ((end - begin) >> 1);
		if(nums[mid] == target) return true;

		return helper(nums, begin, mid - 1, target) || helper(nums, mid + 1, end, target);
	}
}
