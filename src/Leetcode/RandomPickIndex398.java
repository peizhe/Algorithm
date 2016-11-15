package Leetcode;

import java.util.Random;
/**
 * ÂùµõµÄĞîË®³Ø³éÑù
 * 
 * @author MG
 *
 */
public class RandomPickIndex398 {
	private Random random;
	private int[] nums;
	
	public RandomPickIndex398(int[] nums) {
		if(nums == null || nums.length == 0){
			return;
		}
		this.nums = nums;
		random = new Random();
    }
    
    public int pick(int target) {
    	int res = -1;
    	int count = 0;
    	for(int i = 0;i < nums.length;i ++){
    		if(nums[i] != target){
    			continue;
    		}
    		count ++;
    		if(random.nextInt(count) == 0){
    			res = i;
    		}
    	}
        
        return res;
    }
}
