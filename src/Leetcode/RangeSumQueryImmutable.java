package Leetcode;

public class RangeSumQueryImmutable {
	
	public int[] sum;
	public void NumArray(int[] nums) {
		if(nums == null || nums.length == 0){
			sum = null;
		} else{
			sum = new int[nums.length];
			sum[0] = nums[0];
			for(int i = 1;i < nums.length;i ++){
				sum[i] = sum[i - 1] + nums[i];
			}
		}
    }

    public int sumRange(int i, int j) {
    	if(sum == null || j >= sum.length){
    		return 0;
    	}
    	if(i == 0){
    		return sum[j];
    	}
    	else{
    		return sum[j] - sum[i - 1];
    	}
    }
}
