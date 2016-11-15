package Leetcode;

import java.util.Arrays;

/**
 *  
 * @author Administrator
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int[] steps = new int[nums.length];
		Arrays.fill(steps, Integer.MAX_VALUE);
		steps[0] = 0;
		//先执行一遍，这种书写方式要记着
		int j = 0;
		for(int i = 0;i < steps.length;){
			for(;j <= nums[i] + i && j < steps.length;j ++){
				if(steps[i] + 1 < steps[j]){
					steps[j] = steps[i] + 1;
				}
			}
			i ++;
			j = nums[i - 1] + i; 
		}
		
		return steps[steps.length - 1];
    }
}
