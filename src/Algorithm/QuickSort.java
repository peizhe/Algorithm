package Algorithm;

public class QuickSort {
	/**
	 * 绝对能用的
	 * 
	 * 对数组的部分排序，i为初始下标，j为结束下标
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] nums, int i, int j){
		if(i < j){
			int begin = i,end = j,target = nums[begin];;
			while(begin < end){
				while(begin < end && nums[end] >= target){
					end --;
				}
				if(begin < end) nums[begin ++] = nums[end];
				
				while(begin < end && nums[begin] <= target){
					begin ++;
				}
				if(begin < end) nums[end --] = nums[begin];
			}
			
			nums[begin] = target;
			
			quickSort(nums, i, begin - 1);
			quickSort(nums, begin + 1, j);
		} 
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3,5,6,3,2,4,6};
		quickSort(nums, 0, nums.length - 1);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}

}
