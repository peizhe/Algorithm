package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//运用大众投票方法，新的方法，掌握！
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		List<Integer> ls = new ArrayList<Integer>();
		int des1 = nums[0];
		int des2 = 0;
		int count1 = 1;
		int count2 = 0;
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			if (temp == des1) {
				count1++;
			} else if (temp == des2) {
				count2++;
			} else if (count1 == 0) {
				des1 = temp;
				count1 = 1;
			} else if (count2 == 0) {
				des2 = temp;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == des1) {
				count1++;
			} else if (nums[i] == des2) {
				count2++;
			}
		}
		if (count1 > nums.length / 3) {
			ls.add(des1);
		}
		if (count2 > nums.length / 3) {
			ls.add(des2);
		}
		if (des1 == des2) {
			ls.remove(des1);
		}
		return ls;
	}

	public static void main(String[] mh) {
		int[] nums = { 1, 1, 2, 2, 2, 1, 1, 5, 2, 1, 2, 4 };
		MajorityElementII me = new MajorityElementII();
		List<Integer> ls = me.majorityElement(nums);
		Iterator<Integer> it = ls.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
