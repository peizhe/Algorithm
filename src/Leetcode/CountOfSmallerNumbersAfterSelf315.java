package Leetcode;

import java.util.*;
import java.util.List;

/**
 * �����ö��ֲ��ҡ��������������������������鲢�����ʵ��
 * 
 * @author MG
 * 
 */
public class CountOfSmallerNumbersAfterSelf315 {

	class Node {
		int val, leftSum = 0, count = 0;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] count = new Integer[nums.length];
		if (nums.length == 0) {
			return Arrays.asList(count);
		}
		Node root = new Node(nums[nums.length - 1]);
		for (int i = nums.length - 1; i >= 0; i--) {
			count[i] = insert(root, nums[i]);
		}

		return Arrays.asList(count);
	}

	private int insert(Node node, int num) {
		int sum = 0;
		while (node.val != num) {
			if (node.val > num) {
				if (node.left == null)
					node.left = new Node(num);
				node.leftSum++;
				node = node.left;
			} else {
				sum += node.leftSum + node.count;
				if (node.right == null)
					node.right = new Node(num);
				
				node = node.right;
			}
		}
		node.count++;

		return sum + node.leftSum;
	}

	int[] count;

	/**
	 * �鲢����ʵ��
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmallerMergeSort(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		count = new int[nums.length];
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexes[i] = i;
		}
		mergesort(nums, indexes, 0, nums.length - 1);
		for (int i = 0; i < count.length; i++) {
			res.add(count[i]);
		}
		return res;
	}

	private void mergesort(int[] nums, int[] indexes, int start, int end) {
		if (end <= start) {
			return;
		}
		int mid = (start + end) / 2;
		mergesort(nums, indexes, start, mid);
		mergesort(nums, indexes, mid + 1, end);

		merge(nums, indexes, start, end);
	}

	// ����Ԫ�ض��±��������
	private void merge(int[] nums, int[] indexes, int start, int end) {
		int mid = (start + end) / 2;
		int left_index = start;
		int right_index = mid + 1;
		int rightcount = 0;
		int[] new_indexes = new int[end - start + 1];

		int sort_index = 0;
		while (left_index <= mid && right_index <= end) {
			if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
				new_indexes[sort_index] = indexes[right_index];
				rightcount++;
				right_index++;
			} else {
				new_indexes[sort_index] = indexes[left_index];
				count[indexes[left_index]] += rightcount;
				left_index++;
			}
			sort_index++;
		}
		while (left_index <= mid) {
			new_indexes[sort_index] = indexes[left_index];
			count[indexes[left_index]] += rightcount;
			left_index++;
			sort_index++;
		}
		while (right_index <= end) {
			new_indexes[sort_index++] = indexes[right_index++];
		}

		// ��indexs�±���и���(������merge���±귢���仯)
		for (int i = 0; i <= end - start; i++) {
			indexes[i] = new_indexes[i];
		}
	}
}
