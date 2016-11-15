package Leetcode;
/**
 * ����д��û�����⣬ֻ�Ǳ�����������
 * @author MG
 *
 */
public class CountOfRangeSum327 {
	/**
	 * �ڽ���mergeʱ����sum�еĶ�Ӧλ��Ҳ�������ˣ�(���ǽ�ʡ�˵�ʱ��)
	 * 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public int countRangeSumBetter(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	              + countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	    	//�����С��lower�ĸ���
	        while (k < end && sums[k] - sums[i] < lower) k++;
	        //�����С��upper�ĸ���
	        while (j < end && sums[j] - sums[i] <= upper) j++;
	        //��sum[start...mid - 1] ��sum[mid....end]�ϲ���һ�����������
	        while (t < end && sums[t] < sums[i]) cache[r ++] = sums[t ++];
	        cache[r] = sums[i];
	        
	        count += j - k;
	    }
	    
	    System.arraycopy(cache, 0, sums, start, t - start);
	    
	    return count;
	}
	
	
	static int count = 0;
	/**
	 * �Լ�д��,��ȷ��
	 * 
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		if(nums.length == 1){
			return nums[0] >= lower && nums[0] <= upper ? 1 : 0;
		}
		
		
		int len = nums.length;
		int[] sum = new int[len];

		sum[0] = nums[0];
		for (int i = 1; i < len; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}

		divideConque(nums, sum, 0, len - 1, lower, upper);

		return count;
	}

	private static void divideConque(int[] nums, int[] sum, int begin, int end,
			int lower, int upper) {
		if (begin < end) {
			int mid = begin + (end - begin) / 2;
			divideConque(nums, sum, begin, mid, lower, upper);
			divideConque(nums, sum, mid + 1, end, lower, upper);

			merge(nums, sum, begin, mid, end, lower, upper);
		}
	}

	private static void merge(int[] nums, int[] sum, int begin, int mid,
			int end, int lower, int upper) {
		if (begin == mid) {
			count += check(nums[begin], lower, upper);
		}

		if (mid + 1 == end) {
			count += check(nums[end], lower, upper);
		}
		
		for (int i = begin; i <= mid; i++) {
			for (int j = mid + 1; j <= end; j++) {
				count += check(sum[j] - sum[i] + nums[i], lower, upper);
			}
		}
	}

	/**
	 * ���sum �ڷ�Χ[lower, upper]�ڣ�����1�����򷵻�0
	 * 
	 * @param sum
	 * @param lower
	 * @param upper
	 * @return
	 */
	private static int check(int sum, int lower, int upper) {
		return (sum >= lower && sum <= upper) ? 1 : 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 0,0 };
		int lower = 0;
		int upper = 0;
		System.out.println(countRangeSum(nums, lower, upper));
	}

}
