package Algorithm;
/**
 * 这种插入排序的方法还是比较6的
 * @author MG
 *
 */
public class InsertSort {
	public static void insertSort(int[] nums){
		if(nums == null || nums.length < 2){
			return;
		}
		int len = nums.length,temp,j;
		for(int i = 1;i < len;i ++){
			temp = nums[i];
			j = i - 1;
			while(j >= 0 && nums[j] > temp){
				nums[j + 1] = nums[j];
				j -= 1;
			}
			
			nums[j + 1] = temp;
		}
	}
	
	public static void main(String[] mh){
		int[] nums = new int[]{1,2,5,6,3,4,0};
		insertSort(nums);
		for(int i : nums){
			System.out.print(i + " ");
		}
	}
}
