package Algorithm;
/**
 * װ�Ƶ�ð������
 * @author MG
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] nums){
		
	}
	
	//����Ҫ���ٶ���ռ䣬ʵ���������Ľ���
	public static void swap1(int[] nums,int index1,int index2){
		if(nums[index1] != nums[index2]){
			nums[index1] = nums[index1] ^ nums[index2];
			nums[index2] = nums[index2] ^ nums[index1];
			nums[index1] = nums[index1] ^ nums[index2];
		}
	}
	
	public static void swap2(int[] nums,int index1,int index2){
		if(nums[index1] != nums[index2]){
			nums[index1] = nums[index1] + nums[index2];
			nums[index2] = nums[index1] - nums[index2]; 
			nums[index1] = nums[index1] - nums[index2];
		}
	}
	
	public static void swap3(int[] nums,int index1,int index2){
		if(nums[index1] != nums[index2]){
			nums[index1] = nums[index1] * nums[index2];
			nums[index2] = nums[index1] / nums[index2];
			nums[index1] = nums[index1] / nums[index2];
		}
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		int a = 1,b = 3;
		BubbleSort.swap3(nums,a, b);
		for(Integer i : nums){
			System.out.print(i + " ");
		}
	}
}
