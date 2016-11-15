package Algorithm;

/**
 * 通过这道题知道解决此类问题的方法
 * 
 * @author MG
 * 
 */
public class BurstBalloons {
	/**
	 * 
	 * 思想的重点 : 逆向思维(即用最后被扎破的气球将数组进行分类)
	 * 
	 * 循环执行nums[i] * nums[left] * nums[right] :
	 * 		***最后被扎破的气球是nums[i],
	 * 		***nums[left + 1,...,i - 1] 和 nums[i + 1,...,right - 1]都在nums[i]之前扎破(这样左边和右边将不再存在关系)
	 * 
	 * dp 思想 : dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
	 * 
	 * @param num
	 * @return
	 */
	public static int maxCoins(int[] num) {
		int[] nums = new int[num.length + 2];
		int n = 1;
		for (int x : num)
			if (x > 0)
				nums[n++] = x;

		nums[0] = nums[n++] = 1;

		int[][] dp = new int[n][n];
		for (int k = 2; k < n; ++k) {
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
				for (int i = left + 1; i < right; ++i) {
					dp[left][right] = Math.max(dp[left][right], nums[left]
							* nums[i] * nums[right] + dp[left][i]
							+ dp[i][right]);
				}
			}
		}

		return dp[0][n - 1];
	}
	
	
	/**
	 * D&C(分治法)
	 * 
	 * @param iNums
	 *            : 其中的元素均为非负数
	 * @return
	 */
	public int maxCoinsBetter(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;

		// 将iNums中 > 0 的数赋值到nums,其他均为0,
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		// 分别加上头尾，赋值为1
		nums[0] = nums[n++] = 1;

		int[][] memo = new int[n][n];

		return burst(memo, nums, 0, n - 1);
	}

	/**
	 * 
	 * 和dp的思想一样，只是写法更简单了
	 * 
	 * @param memo
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int burst(int[][] memo, int[] nums, int left, int right) {
		//left 与  right 距离为1,(left,right)开区间，中间没有可扎破的气球，因此返回0
		if (left + 1 == right)
			return 0;
		
		//证明前面memo[left][right]已经是最大值了，直接返回就行了
		if (memo[left][right] > 0)
			return memo[left][right];

		int ans = 0;
		for (int i = left + 1; i < right; ++i)
			//nums[i]为最后被扎破的元素
			ans = Math.max(ans, nums[left] * nums[i] * nums[right]
					+ burst(memo, nums, left, i) + burst(memo, nums, i, right));

		memo[left][right] = ans;

		return ans;
	}
}
