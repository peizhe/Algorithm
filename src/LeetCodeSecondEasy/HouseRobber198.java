package LeetCodeSecondEasy;
/**
 * 窃取财物：相邻房间不能同时取：
 * 	1.动态规划
 * @author MG
 *
 */
public class HouseRobber198 {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int length = nums.length;
		if(length == 1){
			return nums[0];
		}
		
        int[] res = new int[length];
        res[0] = nums[0];
        res[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        
        for(int i = 2;i < length;i ++){
        	res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        
        return res[length - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
