package Algorithm;

/**
 * �ֽ��и����⣺��������������
 *  	�ⲻ��0-1�������⣬��Ϊ�и���ÿ���ֽ�ĳ��ȿ�����ͬ
 * @author MG
 *
 */
public class SteelCutting {
	static int maxProfit = Integer.MIN_VALUE;
	/**
	 * �ݹ�ʵ�֣�ʱ�临�Ӷ���O(2 ^ n)(ָ��ʱ����������ʱ)
	 * ��̬�滮ʵ�֣�ʱ�临�Ӷ���O(totalLength * length.length);���ѭ�����ܳ���(totalLength ����)���ڲ�ѭ�����ܹ��и�ĳ���(length[] ����)
	 * 
	 * @param length ���ֲ�ͬ���ȵĸֽ�,Ĭ�ϳ��ȴ�С��������
	 * @param val	ÿ�ֲ�ͬ���ȵĸֽ��Ӧ�ļ۸�
	 * @param totalLength	�ֽ���ܳ���
	 * @return ���ظֽ���и�ķ����Լ��������ֵ
	 */
	public static int cut(int[] length, int[] val, int totalLength){
		int len = length.length;
		int[] dp = new int[totalLength + 1];
		dp[0] = 0;
		
		//����ʾdp
		for(int i = 1;i <= totalLength;i ++) {
			int maxProfit = -1; 
			for(int j = 0;j < len;j ++){
				if(i - length[j] < 0){
					break;
				}
				
				maxProfit = Math.max(maxProfit, dp[i - length[j]] + val[j]); 
			}
			
			dp[i] = maxProfit;
		}
		
		return dp[totalLength];
	}
	
	/**
	 * û�õ������ڶԸֽ�Ƚ�������
	 * 	
	 * @param nums
	 * @param begin
	 * @param end
	 */
	public static void quickSort(int[] nums,int begin, int end){
		if(begin < end){
			
			int left = begin,right = end,target = nums[begin];
			while(left < right){
				while(left < right && nums[right] >= target){
					right --;
				}
				
				if(left < right) nums[left ++] = nums[right];
				
				while(left < right && nums[left] <= target){
					begin ++;
				}
				
				if(left < right) nums[right --] = nums[left];
			}
			
			nums[left] = target;
			
			quickSort(nums, begin, left - 1);
			quickSort(null, left + 1, end);
		}
	}
	
	public static void main(String[] mh) {
		int[] length = new int[]{1,2,3,4};
		int[] val = new int[]{1,5,8,9};
		int totalLength = 4;
		System.out.println(cut(length, val, totalLength));
	}
}
