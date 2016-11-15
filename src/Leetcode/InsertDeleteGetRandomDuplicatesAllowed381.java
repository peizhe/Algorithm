package Leetcode;

import java.util.Random;

public class InsertDeleteGetRandomDuplicatesAllowed381 {
	private Random random;
	private Node root;
	private int countNode;

	public class Node {
		Node[] next;
		int count;

		public Node() {
			next = new Node[2];
			count = 1;
		}
	}

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicatesAllowed381() {
		root = new Node();
		random = new Random();
		countNode = 1;
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		boolean res = false;
		Node temp = root;
		int bit, flag;
		for (int i = 31; i >= 0; i--) {
			bit = val & (1 << i);
			flag = bit == 0 ? 0 : 1;

			if (temp.next[flag] == null) {
				temp.next[flag] = new Node();
				res = true;
			} else {
				temp.next[flag].count++;
			}

			temp = temp.next[flag];
		}

		countNode++;

		return res;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (countNode == 0) {
			return false;
		}

		boolean res = true;
		Node temp = root;
		int bit, flag;
		for (int i = 31; i >= 0; i--) {
			bit = val & (1 << i);
			flag = bit == 0 ? 0 : 1;

			if (temp.next[flag] == null) {
				res = false;
				break;
			}

			temp = temp.next[flag];
		}

		if (res) {
			temp = root;
			for (int i = 31; i >= 0; i--) {
				bit = val & (1 << i);
				flag = bit == 0 ? 0 : 1;

				if (temp.next[flag].count == 1) {
					temp.next[flag] = null;
					break;
				}

				temp.next[flag].count--;
				temp = temp.next[flag];
			}

			countNode--;
		}

		return res;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (countNode == 0) {
			return -1;
		}
		Node temp = root;
		int res = 0;
		int leftCount, rightCount, selection;
		for (int i = 31; i >= 0; i--) {
			leftCount = temp.next[0] == null ? 0 : temp.next[0].count;
			rightCount = temp.next[1] == null ? 0 : temp.next[1].count;
			if (leftCount == 0 || rightCount == 0) {
				selection = leftCount == 0 ? 1 : 0;
			} else {
				// 概率的方法
				selection = random.nextInt(leftCount + rightCount) < leftCount ? 0
						: 1;
			}

			res += selection << i;
			temp = temp.next[selection];
		}

		return res;
	}
}
