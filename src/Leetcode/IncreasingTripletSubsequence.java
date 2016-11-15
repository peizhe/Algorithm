package Leetcode;

/**
 * Return true 
 * if there exists i, j, k 
 * 		such that arr[i] < arr[j] < arr[k] given 0 �� i < j < k �� n-1 
 * else 
 * 		return false.
 * @author MG
 *
 */
public class IncreasingTripletSubsequence {
	/**
	 * �������飬ά��һ����Сֵ���͵����ڶ�Сֵ������ԭ�����ʱ��
	 * �����ǰ����С�ڵ�����Сֵ��������Сֵ�����С�ڵ��ڵ����ڶ�Сֵ�����µ����ڶ�Сֵ��
	 * �����ǰ���ֱ���Сֵ�͵����ڶ�Сֵ����˵����ʱ�������������������ˣ�ֱ�ӷ���true�����������������false
	 */
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3){
			return false;
		}
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i = 0;i < nums.length;i ++){
			if(nums[i] < min){
				min = nums[i];
			}
			else if(nums[i] < secondMin){
				min = nums[i];
			}
			else{
				return true;
			}
		}
		
		return false;
    }
}
