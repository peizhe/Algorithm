package Leetcode;

public class SearchinRotatedSortedArray {
	int index = -1;

	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return index;
		}

		binarySearch(nums, target, 0, nums.length - 1);
		return index;
	}

	private void binarySearch(int[] nums, int target, int left, int end) {
		if (left > end) {
			return;
		}

		int mid = left + (end - left) / 2;
		if (nums[mid] == target) {
			index = mid;
			return;
		}

		binarySearch(nums, target, left, mid - 1);
		binarySearch(nums, target, mid + 1, end);
	}
}
