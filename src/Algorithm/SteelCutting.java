package Algorithm;

/**
 * 钢筋切割问题：和找零问题类似
 *  	这不是0-1背包问题，因为切割后的每个钢筋的长度肯能相同
 * @author MG
 *
 */
public class SteelCutting {
	static int maxProfit = Integer.MIN_VALUE;
	/**
	 * 递归实现：时间复杂度是O(2 ^ n)(指数时间增长，费时)
	 * 动态规划实现：时间复杂度是O(totalLength * length.length);外层循环是总长度(totalLength 参数)，内层循环是能够切割的长度(length[] 参数)
	 * 
	 * @param length 多种不同长度的钢筋,默认长度从小到大排序
	 * @param val	每种不同长度的钢筋对应的价格
	 * @param totalLength	钢筋的总长度
	 * @return 返回钢筋的切割的方法以及获得最大价值
	 */
	public static int cut(int[] length, int[] val, int totalLength){
		int len = length.length;
		int[] dp = new int[totalLength + 1];
		dp[0] = 0;
		
		//外层表示dp
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
	 * 没用到，用于对钢筋长度进行排序
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
