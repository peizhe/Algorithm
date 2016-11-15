package Leetcode;


public class NextPermutation31 {
	
	public static void nextPermutation(int[] num) {
		int i = num.length - 2;
		
		for(;i >= 0 && num[i] >= num[i + 1];i --);
		
		if(i >= 0) {
			int j = i + 1;
			//nums[i + 1...len - 1]中寻找 第一个 大于 nums[i]的元素，然后与nums[i]交换
			for(;j < num.length && num[i] < num[j]; j++);
			
			swap(num, i, j - 1);
		}
		
		i ++ ; 
		int k = num.length - 1;
		for(;i < k;i ++, k --)
			swap(num, i, k);
	}
	
	private static void swap(int[] nums, int i, int j){
		if(nums[i] != nums[j]){
			nums[i] = nums[i] ^ nums[j];
			nums[j] = nums[i] ^ nums[j];
			nums[i] = nums[i] ^ nums[j];
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,3,1};
		nextPermutation(nums);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}

}
