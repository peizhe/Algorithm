package LeetCodeSecondMedium;

public class LongestIncreasingSubsequence300 {
	public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int len = nums.length;
        int res = 1;
        
        for(int i = 1; i < len; i++) {
        	int insertIndex = binarySearch(nums, res, nums[i]);
        	
        	nums[insertIndex] = nums[i];
        	
        	res += insertIndex == res ? 1 : 0;
        }
        
        return res;
    }
	
	private static int binarySearch(int[] nums, int end, int target) {
		int left = 0, right = end - 1;
		while(left <= right) {
			int mid = left + ((right - left) >> 1);
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	public static void main(String[] mh) {
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
}
