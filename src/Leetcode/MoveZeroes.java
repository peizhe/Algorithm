package Leetcode;

public class MoveZeroes {
	/**
	 * ˼�룺
	 * 1.����������0�ĸ���
	 * 2.ÿ��ѭ���ҵ���Ϊ0������Ȼ�󽫸�����ֵ��nums[i],
	 * 3.���������±긳ֵ��k��kΪÿ��ѭ���Ŀ�ʼ�㣨j�ĳ�ֵ��
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
				//�ҵ���i����Ϊ0������ֵ��num[i]
				nums[i] = nums[j];
				i ++;
				//��jֵ��ֵ��k���´δ�k��ʼѭ��
				k = j + 1;
			}
		}
		
		for(int p = count;p < nums.length;p ++){
			nums[p] = 0;
		}
    }
}
