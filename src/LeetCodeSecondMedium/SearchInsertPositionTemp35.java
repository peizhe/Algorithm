package LeetCodeSecondMedium;

public class SearchInsertPositionTemp35 {
	public static int searchInsert(int[] nums, int target) { 
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int begin = 0, end = nums.length - 1;
		while(begin <= end) {
			int mid = begin + ((end - begin) >> 1);
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] > target) {
				end = mid - 1;
			} else {
				begin = mid + 1;
			}
		}
		
		return begin;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums, target));
	}

}
