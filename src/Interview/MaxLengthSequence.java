package Interview;

import java.util.Arrays;

/**
 * 一个序列只有-1和1组成，找出和为0的最长子序列长度
 * @author MG
 *
 */
public class MaxLengthSequence {
	public static int maxLength(int[] nums){
		int len = nums.length;
		int[] sum = new int[len];
		sum[0] = nums[0];
		int max = nums[0],min = nums[0];
		for(int i = 1;i < len;i ++){
			sum[i] = sum[i - 1] + nums[i];
			if(sum[i] > max){
				max = sum[i];
			}
			
			if(sum[i] < min){
				min = sum[i];
			}
		}
		
		int[] index = new int[max - min + 1];
		Arrays.fill(index, -1);
		int res = 0,tempIndex;
		for(int i = 0;i < len;i ++){
			tempIndex = sum[i] - min;
			if(index[tempIndex] != -1){
				int temp = sum[i] == 0 ? i + 1 : i - index[tempIndex];
				if(temp > res) {
					res = temp;
				}
			} else {
				index[sum[i] - min] = i;
			}
		}
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,1,-1,-1,-1,1,-1,1,-1};
		System.out.println(maxLength(nums));
	}

}
