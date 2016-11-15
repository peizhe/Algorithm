package LeetCodeSecondMedium;

public class ProductOfArrayExceptSelf238 {
	public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
        	return new int[0];
        }
        int len = nums.length;
        
        int[] res = new int[len];
        int temp = 1;
        res[0] = 1;
        for(int i = 1;i < len;i ++){
        	res[i] = res[i - 1] * nums[i - 1];
        }
        
        for(int i = len - 1;i >= 0;i --){
        	res[i] *= temp;
        	temp *= nums[i];
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
