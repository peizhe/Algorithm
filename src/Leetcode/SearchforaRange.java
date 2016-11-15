package Leetcode;

public class SearchforaRange {
	
	int[] result = new int[]{-1,-1};
	public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
        	return result;
        }
        
        result[0] = nums.length;
        result[1] = -1;
        searchRangeHelp(nums,target,0,nums.length - 1);
        
        if(result[0] == nums.length && result[1] == -1){
        	result[0] = -1;
        	result[1] = -1;
        }
        
        return result;
    }
	
	public void searchRangeHelp(int[] nums,int target,int begin,int end){
		if(begin > end){
			return;
		}
		
		int mid = begin + (end - begin) / 2;
		
		if(nums[mid] < target){
			searchRangeHelp(nums, target,mid + 1,end);
		}
		
		else if(nums[mid] > target){
			searchRangeHelp(nums, target, begin, mid - 1);
		}
		else{
			if(mid < result[0]){
				result[0] = mid;
			}
			
			if(mid > result[1]){
				result[1] = mid;
			}
			
			searchRangeHelp(nums, target,mid + 1,end);
			searchRangeHelp(nums, target, begin, mid - 1);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 10;
		
		try {
			Class<?> c = Class.forName("leetcode.SearchforaRange");
			
			SearchforaRange s = (SearchforaRange)c.newInstance();
			
			s.searchRange(nums, target);
			
			System.out.println(s.result[0] + " " + s.result[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
