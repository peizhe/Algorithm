package Leetcode;

public class SearchInsertPosition {
	
	public static int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length - 1;
        while(start < end){
        	int mid = start + (end - start) / 2;
        	if(target < nums[mid]){
        		end = mid - 1;
        	}
        	else if(target > nums[mid]){
        		start = mid + 1;
        	}
        	else if(target == nums[mid]){
        		return mid;
        	}
        }
        
        if(nums[start] < target){
        	return start + 1;
        }
        else{
        	return start;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,6};
		int target = 4;
		System.out.println(searchInsert(a, target));
	}

}
