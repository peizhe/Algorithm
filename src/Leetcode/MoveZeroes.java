package Leetcode;

public class MoveZeroes {
	/**
	 * 思想：
	 * 1.计算数组中0的个数
	 * 2.每次循环找到不为0的数，然后将该数赋值给nums[i],
	 * 3.将该数的下标赋值给k，k为每次循环的开始点（j的初值）
	 */
	public static void moveZeroes(int[] nums) {
		int count = 0;
		for(int i = 0;i < nums.length;i ++){
			if(nums[i] != 0){
				count ++;
			}
		}
		
		int k = 0;
		int i = 0,j;
		
		for(j = k;j < nums.length;j ++){
			if(nums[j] != 0){
				//找到第i个不为0的数赋值给num[i]
				nums[i] = nums[j];
				i ++;
				//把j值赋值给k，下次从k开始循环
				k = j + 1;
			}
		}
		
		for(int p = count;p < nums.length;p ++){
			nums[p] = 0;
		}
    }
}
