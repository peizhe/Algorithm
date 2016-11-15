package HihoCoder;

/**
 * 题目 : 
 * 
 * 1.排序的思想超时了(将下标根据下标对应的值排序,判断排序后的下标对应的值和原下标对应的值是否相等)
 * 2.如下
 * 
 * @author MG
 * 
 */
public class SmallestSubArray1409 {
	public static int getCountBetter(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int left = 0;
		int right = len - 1;

		while (left < right && nums[left] <= nums[left + 1]) {
			left++;
		}

		if (left == right) {
			return 0;
		}

		while (nums[right - 1] <= nums[right]) {
			right--;
		}

		int min = 100000009;
		int max = -9;

		for (int i = left; i <= right; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}

			if (min > nums[i]) {
				min = nums[i];
			}
		}

		while (left != -1 && min < nums[left]) {
			left--;
		}
		while (right != len && max > nums[right]) {
			right++;
		}

		return right - left - 1;
	}

	public static int getCount(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int[] index = new int[len];
		for (int i = 0; i < len; i++) {
			index[i] = i;
		}

		boolean isExchange = true;
		for (int i = len - 1; i >= 0; i--) {
			if (!isExchange) {
				break;
			}

			isExchange = false;
			for (int j = 0; j < i; j++) {
				if (nums[index[j]] > nums[index[j + 1]]) {
					index[j] = index[j] ^ index[j + 1];
					index[j + 1] = index[j] ^ index[j + 1];
					index[j] = index[j] ^ index[j + 1];

					isExchange = true;
				}
			}
		}

		int begin = 0, end = len - 1;
		while (begin <= end
				&& (nums[begin] == nums[index[begin]] || nums[end] == nums[index[end]])) {

			if (nums[begin] == nums[index[begin]]) {
				begin++;
			}

			if (nums[end] == nums[index[end]]) {
				end--;
			}
		}

		return begin > end ? 0 : end - begin + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 3, 6, 7, 5, 4, 8 };
		System.out.println(getCountBetter(nums));
	}

}
