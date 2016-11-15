package Leetcode;

/**
 * Return true 
 * if there exists i, j, k 
 * 		such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 
 * else 
 * 		return false.
 * @author MG
 *
 */
public class IncreasingTripletSubsequence {
	/**
	 * 遍历数组，维护一个最小值，和倒数第二小值，遍历原数组的时候，
	 * 如果当前数字小于等于最小值，更新最小值，如果小于等于倒数第二小值，更新倒数第二小值，
	 * 如果当前数字比最小值和倒数第二小值都大，说明此时有三个递增的子序列了，直接返回true，否则遍历结束返回false
	 */
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3){
			return false;
		}
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i = 0;i < nums.length;i ++){
			if(nums[i] < min){
				min = nums[i];
			}
			else if(nums[i] < secondMin){
				min = nums[i];
			}
			else{
				return true;
			}
		}
		
		return false;
    }
}
