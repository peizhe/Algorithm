package Algorithm;

/**
 * ͨ�������֪�������������ķ���
 * 
 * @author MG
 * 
 */
public class BurstBalloons {
	/**
	 * 
	 * ˼����ص� : ����˼ά(����������Ƶ�����������з���)
	 * 
	 * ѭ��ִ��nums[i] * nums[left] * nums[right] :
	 * 		***������Ƶ�������nums[i],
	 * 		***nums[left + 1,...,i - 1] �� nums[i + 1,...,right - 1]����nums[i]֮ǰ����(������ߺ��ұ߽����ٴ��ڹ�ϵ)
	 * 
	 * dp ˼�� : dp[l][r]��ʾ����(l, r)��Χ�����������õ����Ӳ�����������߽磻
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
	 * D&C(���η�)
	 * 
	 * @param iNums
	 *            : ���е�Ԫ�ؾ�Ϊ�Ǹ���
	 * @return
	 */
	public int maxCoinsBetter(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;

		// ��iNums�� > 0 ������ֵ��nums,������Ϊ0,
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		// �ֱ����ͷβ����ֵΪ1
		nums[0] = nums[n++] = 1;

		int[][] memo = new int[n][n];

		return burst(memo, nums, 0, n - 1);
	}

	/**
	 * 
	 * ��dp��˼��һ����ֻ��д��������
	 * 
	 * @param memo
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public int burst(int[][] memo, int[] nums, int left, int right) {
		//left ��  right ����Ϊ1,(left,right)�����䣬�м�û�п����Ƶ�������˷���0
		if (left + 1 == right)
			return 0;
		
		//֤��ǰ��memo[left][right]�Ѿ������ֵ�ˣ�ֱ�ӷ��ؾ�����
		if (memo[left][right] > 0)
			return memo[left][right];

		int ans = 0;
		for (int i = left + 1; i < right; ++i)
			//nums[i]Ϊ������Ƶ�Ԫ��
			ans = Math.max(ans, nums[left] * nums[i] * nums[right]
					+ burst(memo, nums, left, i) + burst(memo, nums, i, right));

		memo[left][right] = ans;

		return ans;
	}
}
