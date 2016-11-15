package Algorithm;
/**
 * 通过二分查找的方法进行搜索第一个大于x的数:
 * 	技巧 : begin end  ！！！begin = mid(不可以这样赋值,会陷入死循环)
 * 		当begin + 1 = end时, mid = begin + (end - begin) / 2 = begin(因此陷入了死循环)
 * 
 * 再一个有序数组中找到第一个大于等于target的数
 * 
 * @author MG
 *
 */
public class FindFirstMoreThanX {
	
	
	/**
	 * 数组有序
	 * 
	 * 找到第一个大于X的数的下标或者找到最后一个小于X的数的下标
	 * 
	 * @param nums
	 * @param target
	 * @param firstMaxOrLastMin 标记是求第一个比x大的数的下标(True)，还是求最后一个比x小的数的下标(False)
	 * @return
	 */
	private static int findFirstMoreThanX(int[] nums, int target, boolean firstMaxOrLastMin){
		int begin = 0, end = nums.length - 1;
		while(begin < end) {
			int mid = begin + ((end - begin) >> 1);
			if(nums[mid] > target) end = mid;
			else if(nums[mid] < target) begin = mid + 1;
			else return mid;
		}
		
		//寻找第一个比target大的数
		if(firstMaxOrLastMin) return begin == nums.length - 1 ? -1 : begin;
		//寻找最后一个比target小的数
		else return begin == 0 ? -1 : begin - 1; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,3,5,7,11,12,13,13,17,19,20,24};
		int target = 1;
		System.out.println(findFirstMoreThanX(nums, target, false));
	}

}
