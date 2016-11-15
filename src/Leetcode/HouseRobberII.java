package Leetcode;
/**
 * 因为第一个element 和最后一个element不能同时出现. 则分两次call House Robber I. 
 * case 1: 不包括最后一个element. 
 * case 2: 不包括第一个element.
 * @author MG
 */
public class HouseRobberII {
	public static int robsub(int[] nums,int s,int e){
		int n = e - s + 1;
		int[] max = new int[n];
		max[0] = nums[s];
		max[1] = Math.max(nums[s], nums[s + 1]);
		for(int i = 2;i < n;i ++){
			 max[i] = Math.max(max[i - 2] + nums[s + i], max[i - 1]);
		}
		
		return max[n - 1];
	}
	public static int rob(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		else if(nums.length == 1){
			return nums[0];
		}
		else if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		else{
			return Math.max(robsub(nums,0,nums.length - 2), robsub(nums,1,nums.length - 1));
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,8,7};
		System.out.println(rob(a));
	}
}
