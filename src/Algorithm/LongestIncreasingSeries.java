package Algorithm;

import java.util.Arrays;

/**
 * ����������г��ȵļ��ַ�����
 * 	1.dfs : ��ʱ
 * 	2.dp : O(n ^ 2)
 * 	3.���ŵķ���(O(nlogn),��Ч��)
 * @author MG
 *
 */
public class LongestIncreasingSeries {
	
	private static int lisDP(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int res = 1;
		int len = nums.length;
		int[] dp = new int[len];
		
		for(int i = 0;i < len;i ++){
			dp[i] = 1;
			for(int j = 0;j < i;j ++){
				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			res = Math.max(dp[i], res);
		}
		
		return res;
	}
	
	/**
	 * ֻ���㳤��ʹ�������죬����������в���ʹ��
	 * @param nums
	 * @return
	 */
	private static int lisBest(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int len = nums.length;
		int[] stack = new int[len];
		
		int res = 0;
		for(int i : nums) {
			int index = Arrays.binarySearch(stack, 0, res, i);
			//���Ƕ��ֲ���Դ���з��ص�(���û�ҵ����򷵻� -(index + 1))
            if(index < 0)
                index = -(index + 1);
            
            stack[index] = i;
            
            if(index == res)
                res ++;
		}
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,3,2,4,5,7,6,8};
		System.out.println(lisDP(nums) + " " + lisBest(nums));
	}

}
