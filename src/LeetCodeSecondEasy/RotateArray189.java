package LeetCodeSecondEasy;

public class RotateArray189 {
	public static void rotate(int[] nums, int k) {
		if(nums == null || nums.length == 1 || k == 0){
			return;
		}
		
		int len = nums.length;
		k = k % len;
		
		reverse(nums, 0, len - k - 1);
		reverse(nums, len - k, len - 1);
		reverse(nums, 0, len - 1);
	}
	
	private static void reverse(int[] nums,int begin,int end){
		while(begin < end){
			nums[begin] = nums[begin] ^ nums[end];
			nums[end] = nums[begin] ^ nums[end];
			nums[begin] = nums[begin] ^ nums[end];
			
			begin ++;
			end --;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2};
		rotate(nums, 1);
	}

}
