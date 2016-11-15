package Leetcode;
import java.util.*;


public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0)
        {
        	return false;
        }
        Map<Integer,Integer> ma = new HashMap<Integer,Integer>();
		for(int i = 0;i < nums.length;i ++)
        {
			if(ma.containsKey(nums[i]))
			{
				if(i - ma.get(nums[i]) <= k)
				{
					return true;
				}
				else
				{
					ma.put(nums[i], i);
				}
			}
			else
			{
				ma.put(nums[i], i);
			}
        }
		
		return false;
    }
	public static void main(String[] mh)
	{
		ContainsDuplicateII cd2 = new ContainsDuplicateII();
		int[] nums = {1,2,3,4,6,6};
		int k = 2;
		System.out.println(cd2.containsNearbyDuplicate(nums, k));
	}
}
