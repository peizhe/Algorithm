package LeetCodeSecondMedium;

public class IncreasingTripletSubsequence334 {

	public static boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length <= 2){
			return false;
		}
		
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE,len = nums.length;
		for(int i = 0;i < len;i ++){
			if(nums[i] <= min){
				min = nums[i];
			} else if(nums[i] <= secondMin){
				secondMin = nums[i];
			} else {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,2,2,3,6,1,3,2};
		System.out.println(increasingTriplet(nums));
	}
}
