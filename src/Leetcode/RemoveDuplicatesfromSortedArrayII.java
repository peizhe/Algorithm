package Leetcode;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int index = 1;
		int twice = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				twice++;
				if (twice == 2) {
					nums[index] = nums[i];
					index = index + 1;
				}
				continue;
			} else {
				nums[index] = nums[i];
				twice = 1;
				index++;
			}
		}
		return index;
	}

	public static void main(String[] mh) {
		int[] a = { 1, 1, 1, 1, 3, 3 };
		RemoveDuplicatesfromSortedArrayII re2 = new RemoveDuplicatesfromSortedArrayII();
		System.out.println(re2.removeDuplicates(a));
	}
}
