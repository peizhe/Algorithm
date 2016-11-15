package Leetcode;

/**
 * 
 * @author MG
 * 
 */
public class RemoveKDigits402 {
	// 时间效率更高，更厉害的方法
	public String removeKdigitsBetter(String num, int k) {
		final char[] nums = num.toCharArray();
		int x = 0;
		for (int i = 0; i < k; i++) {
			if (x >= nums.length - 1) {
				x++;
				break;
			}

			if (nums[x + 1] == '0') {
				// next is zero, let's also remove all possible zeros
				x = x + 2;
				while (x < nums.length && nums[x] == '0') {
					x++;
				}
			} else if (nums[x] > nums[x + 1]) {
				// next is not zero and is smaller than current, happy path
				x++;
			} else {
				// next is not zero, and is greater than or equal to current
				// let's find the largest possible digit to remove
				// e.g. "2231" should remove '3'
				int y = x + 1;
				while (y < nums.length - 1 && nums[y] <= nums[y + 1]) {
					y++;
				}
				// in the simple case, this array copy is idential to nums[x +
				// 1] = nums[x]
				System.arraycopy(nums, x, nums, x + 1, y - x);
				x++;
			}
		}

		return nums.length > x ? new String(nums, x, nums.length - x) : "0";
	}

	public static String removeKdigits(String num, int k) {
		int len = num.length();
		int digits = len - k;
		char[] stk = new char[len];
		int top = 0;
		// k keeps track of how many characters we can remove
		// if the previous character in stk is larger than the current one
		// then removing it will get a smaller number
		// but we can only do so when k > 0
		for (int i = 0; i < len; ++i) {
			char c = num.charAt(i);
			// 模拟的栈的操作
			while (top > 0 && stk[top - 1] > c && k > 0) {
				top -= 1;
				k -= 1;
			}
			stk[top++] = c;
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stk[idx] == '0')
			idx++;

		return idx == digits ? "0" : new String(stk, idx, digits - idx);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeKdigits("1432219", 3);
	}

}
