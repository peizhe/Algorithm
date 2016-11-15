package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> ls = new ArrayList<Integer>();

	public void push(int x) {
		ls.add(x);
	}

	public void pop() {
		ls.remove(ls.size() - 1);
	}

	public int top() {
		return ls.get(ls.size() - 1);
	}

	public int getMin() {
		int min = ls.get(0);
		for (int i = 1; i < ls.size(); i++) {
			int temp = ls.get(i);
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}
}
