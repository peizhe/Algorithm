package Leetcode;
import java.util.*;


public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if(nums.length == 0)
		{
			return false;
		}
        Set<Integer> se = new HashSet<Integer>();
        for(int i = 0;i < nums.length;i ++)
        {
        	se.add(nums[i]);
        }
        if(se.size() == nums.length)
        {
        	return false;
        }
        else
        {
        	return true;
        }
    }
	public static void main(String[] mh)
	{
		int[] nums = {1,2,3,4,6,6};
		ContainsDuplicate cd = new ContainsDuplicate();
		System.out.println(cd.containsDuplicate(nums));
	}
}
