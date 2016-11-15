package Leetcode;
/**
 * ��Ϊ��һ��element �����һ��element����ͬʱ����. �������call House Robber I. 
 * case 1: ���������һ��element. 
 * case 2: ��������һ��element.
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
