package Leetcode;
/**
 * 这是本算法的重点(动态规划)
 * max[i]代表到第i个房间所能获得的最大价值
 * 初始化
 * max[0] = nums[0];
 * max[1] = Math.max(nums[0], nums[1]);
 * maxV[i] = max(maxV[i-2] + num[i], maxV[i-1])
 * @author MG
 */
public class HouseRobber {
	
	public static int rob(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		int[] max = new int[nums.length];
		max[0] = nums[0];
		max[1] = Math.max(nums[0], nums[1]);
		
		for(int i = 2;i < max.length;i ++){
			max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
		}
		
		return max[max.length - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1};
		
		System.out.println(rob(a));
	}
}
