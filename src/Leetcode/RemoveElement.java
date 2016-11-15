package Leetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[start] = nums[i];
				start++;
			}
		}
		return start;
	}

	public static void main(String[] mh) {
		RemoveElement re = new RemoveElement();
		int[] nums = { 4, 5 };
		int val = 4;
		System.out.println(re.removeElement(nums, val));
	}
}
