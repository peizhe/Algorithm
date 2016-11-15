package LeetCodeSecondMedium;

public class SearchInsertPosition35 {
	public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int len = nums.length,mid;
        int begin = 0,end = len - 1;
        while(begin <= end){
        	mid = begin + (end - begin) / 2;
        	
        	if(nums[mid] == target){
        		return mid;
        	} else if(nums[mid] < target){
        		begin = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        
        return begin;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums,target));
	}

}
