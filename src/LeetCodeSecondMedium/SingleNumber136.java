package LeetCodeSecondMedium;

public class SingleNumber136 {
	public int singleNumber(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int res = nums[0];
		int len = nums.length;
        for(int i = 1;i < len;i ++){
        	res ^= nums[i];
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
