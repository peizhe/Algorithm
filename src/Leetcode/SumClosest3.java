package Leetcode;
//Ç°ºóÖ¸ÕëÑ°ÕÒ
public class SumClosest3 {
	public int threeSumClosest(int[] nums, int target) {
		int result = 0;
        for(int i = nums.length - 1;i > 0;i --)
        {
        	for(int j = 0;j < i;j ++)
        	{
        		if(nums[j] > nums[j + 1])
        		{
        			int temp = nums[j];
        			nums[j] = nums[j + 1];
        			nums[j + 1] = temp;
        		}
        	}
        }
        int begin,end,absMax = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length - 2;i ++)
        {
        	begin = i + 1;
        	end = nums.length - 1;
        	while(begin < end)
        	{
        		int temp = nums[i] + nums[begin] + nums[end];
        		if(temp == target)
        		{
        			return temp;
        		}
        		else if(temp < target)
        		{
        			if(Math.abs(temp - target) < absMax)
        			{
        				absMax = Math.abs(temp - target);
        				result = temp; 
        			}
        			begin ++;
        		}
        		else
        		{
        			if(Math.abs(temp - target) < absMax)
        			{
        				absMax = Math.abs(temp - target);
        				result = temp; 
        			}
        			end --;
        		}
        	}
        }
        return result;
    }
	public static void main(String[] mh)
	{
		int[] a = {0,2,1};
		int target = 0;
		SumClosest3 sc = new SumClosest3();
		System.out.println(sc.threeSumClosest(a, target));
	}
}
