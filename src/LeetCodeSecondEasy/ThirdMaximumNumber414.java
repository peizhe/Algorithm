package LeetCodeSecondEasy;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber414 {

	public int thirdMax(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		} else {
			Set<Integer> set = new HashSet<Integer>();

			Integer first = null, second = null, third = null;
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i]))
					continue;

				if (first == null || nums[i] > first) {
					
					third = second;
					second = first;
					
					first = nums[i];
				} else if (second == null || nums[i] > second) {
					third = second;
					
					second = nums[i];
				} else if (third == null || nums[i] > third) {
					third = nums[i];
				}
				
				set.add(nums[i]);
			}

			return third == null ? first : third;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
