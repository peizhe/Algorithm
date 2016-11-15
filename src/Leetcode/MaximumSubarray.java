package Leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		//全是负数的情况
		int max = Integer.MIN_VALUE;
		int count = 0;
		for(int i = 0;i < nums.length;i ++)
		{
			if(nums[i] > max)
			{
				max = nums[i];
			}
			if(nums[i] <= 0)
			{
				count ++;
			}
		}
		if(count == nums.length)
		{
			return max;
		}
		
		//有正有负的情况
        int result = 0;
        int temp = 0;
        for(int i = 0;i < nums.length;i ++)
        {
        	temp = temp + nums[i]; 
        	if(temp < 0)
        	{
        		temp = 0;
        	}
        	else if(temp > result)
        	{
        		result = temp;
        	}
        }
        return result;
    }
	public static void main(String[] mh)
	{
		int[] a = {-2,-3,-1,-5,-4};
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(a));
	}
}
