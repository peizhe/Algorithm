package LeetCodeSecondMedium;

public class MissingNumber268 {
	public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0; 
        }
        
        int len = nums.length;
        int mul = (len * (len + 1)) >> 1;
        
        for(int i : nums){
        	mul -= i;
        }
        
        return mul;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
