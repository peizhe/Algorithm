package Leetcode;

public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if(len < 2) {
        	return nums;
        }
        
        int[] result = new int[len];
        result[len - 1] = 1;
        for(int i = len - 1;i > 0;i --) {
        	result[i - 1] = result[i] * nums[i];
        }
        
        int left = 1;
        for(int i = 0;i < len;i ++) {
        	result[i] = result[i] * left;
        	left = left * nums[i];
        }
        
        return result;
    }
}
