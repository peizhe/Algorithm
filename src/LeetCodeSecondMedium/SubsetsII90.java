package LeetCodeSecondMedium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SubsetsII90 {
	//这种方法比较快
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		subsetsWithDupHelper(nums, 0, res, new ArrayList<Integer>());
		return res;
	}

	private static void subsetsWithDupHelper(int[] nums, int pos,
			List<List<Integer>> res, ArrayList<Integer> arrayList) {
		// subset means it does not need contain all elements, so the condition
		// is <= rather than ==
		// and do not return after this statement
		if (pos <= nums.length)
			res.add(new ArrayList<>(arrayList));

		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i - 1])
				continue; // avoid duplicates
			arrayList.add(nums[i]);
			subsetsWithDupHelper(nums, i + 1, res, arrayList);
			arrayList.remove(arrayList.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 2, 2 };
		System.out.println(subsetsWithDup(nums).size());
	}

}
