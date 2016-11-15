package Leetcode;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			} else {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	public static void main(String[] mh) {
		int[] a = { 0, 1, 1, 2, 3, 3, 6, 7, 7, 8 };
		RemoveDuplicatesfromSortedArray re = new RemoveDuplicatesfromSortedArray();
		System.out.println(re.removeDuplicates(a));
	}
}
