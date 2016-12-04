package LeetCodeSecondMedium;

public class RemoveDuplicatesFromSortedArrayII80 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int index = 1, twice = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (++twice == 2) nums[index ++] = nums[i];
			} else {
				nums[index ++] = nums[i];
				twice = 1;
			}
		}

		return index;
	}
}
