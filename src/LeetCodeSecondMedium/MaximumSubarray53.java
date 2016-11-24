package LeetCodeSecondMedium;

public class MaximumSubarray53 {
	public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int res = 0, sum = 0, len = nums.length, max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
        	sum += nums[i];
        	
        	max = nums[i] < 0 && nums[i] > max ? nums[i] : max;
        	
        	sum = sum < 0 ? 0 : sum;
        	
        	res = sum > res ? sum : res;
        }
        
        return res == 0 ? max : res;
    }
	
	public static void main(String[] mh) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}

}
