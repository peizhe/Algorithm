package LeetCodeSecondMedium;

public class SortColors75 {
	public void sortColors(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int red = 0, green = 0, blue = 0;
        for(int i : nums) {
        	if(i == 0) red ++;
        	else if(i == 1) green ++;
        	else blue ++;
        }
        
        int index = 0;
        for(; red > 0; red--) nums[index ++] = 0;
        for(; green > 0; green--) nums[index ++] = 1;
        for(; blue > 0; blue--) nums[index ++] = 2;	
    }
}
