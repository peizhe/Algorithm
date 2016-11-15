package Leetcode;

public class SearchinRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public boolean binarySearch(int[] nums, int target, int left, int right) {
		if (left > right) {
			return false;
		}
		int mid = left + (right - left) / 2;

		if (nums[mid] == target) {
			return true;
		} else {
			return binarySearch(nums, target, left, mid - 1)
					|| binarySearch(nums, target, mid + 1, right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
