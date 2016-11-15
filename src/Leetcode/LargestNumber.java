package Leetcode;
import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {
	public String largestNumber(int[] nums) {
		//判断是否全为0
		int index = 0;
		for(;index < nums.length;index ++)
		{
			if(nums[index] != 0)
			{
				break;
			}
		}
		if(index == nums.length)
		{
			return "0";
		}
		
        String result = "";
        String[] num = new String[nums.length];
        for(int i = 0;i < nums.length;i ++)
        {
        	num[i] = nums[i] + "";
        }
        //此分类函数有点不明白
        Arrays.sort(num,new Cmp());
        for(int i = num.length - 1;i >= 0;i --)
        {
        	result = result + num[i];
        }
      
        return result;
    }
	//比较器
	class Cmp implements Comparator<String>
	{
		public int compare(String a,String b)
		{
			String ab = a.concat(b);  
	        String ba = b.concat(a);  
	        return (int)(Long.parseLong(ab) - Long.parseLong(ba)); 
		}
	}
	
	public static void main(String[] mh)
	{
		LargestNumber ln = new LargestNumber();
		int[] nums = {999999998,999999997,999999999};
		System.out.println(ln.largestNumber(nums));
	}
}
