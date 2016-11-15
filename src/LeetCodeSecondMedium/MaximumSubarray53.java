package LeetCodeSecondMedium;

public class MaximumSubarray53 {
	public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        if(nums.length == 1){
        	return nums[0];
        }
        
        int res = 0;
        int sum = 0,temp = Integer.MIN_VALUE,len = nums.length;
        for(int i = 0;i < len;i ++){
        	
        	temp = nums[i] <= 0 ? nums[i] > temp ? nums[i] : temp : temp;
        	
        	sum = sum < 0 ? 0 : sum;
        	
        	sum += nums[i];
        	
        	res = sum > res ? sum : res; 
        }
        
        return res <= 0 ? temp : res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-2,-1};
		System.out.println(maxSubArray(nums));
	}

}
