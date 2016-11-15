package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Divide and conquer : 分治法，这是解决问题的一种思想
 * 	思想 : 先将字符串分解成数字和操作符
 * 	
 * @author MG
 * 
 */
public class DifferentWaysToAddParentheses241 {
	public List<Integer> diffWaysToCompute(String input) {
		if (input == null || input.length() == 0) {
			return new ArrayList<Integer>();
		}
		
		if(input.charAt(0) == '-') input = "0" + input;

		int len = input.length();

		List<Integer> nums = new ArrayList<Integer>();
		List<Character> operator = new ArrayList<Character>();
		
		int number = -1;
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if (isNum(ch)) {
				if(number < 0) number = ch - '0';
				else {
					number *= 10;
					number += ch - '0';
				}
				
			} else {
				if(number >= 0) {
					nums.add(number);
					number = -1;
				} 
				operator.add(ch);
			}
		}
		
		nums.add(number);

		return calucate(nums, operator, 0, nums.size() - 1);
	}

	/**
	 * 注意end这个参数
	 * List<Integer> nums : 	  1 2 3 4 5
	 * List<Character> operator : - + - * 
	 * 
	 * @param nums
	 * @param operator
	 * @param begin
	 * @param end
	 * @return
	 */
	private List<Integer> calucate(List<Integer> nums,List<Character> operator, int begin, int end) {
		List<Integer> res = new ArrayList<Integer>();
		if (begin == end) {
			res.add(nums.get(begin));
		} else if (begin + 1 == end) {
			res.add(getVal(nums.get(begin), nums.get(end), operator.get(begin)));
		} else {
			//这里循环的是操作符
			for (int i = begin; i < end; i++) {
				List<Integer> left = calucate(nums, operator, begin, i);
				List<Integer> right = calucate(nums, operator, i + 1, end);
				
				for(int l : left){
					for(int r : right){
						res.add(getVal(l, r, operator.get(i)));
					}
				}
			}
		}
		
		return res;
	}

	private int getVal(int a, int b, char operator) {
		if (operator == '+') {
			return a + b;
		} else if (operator == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	private boolean isNum(char ch) {
		return ch >= '0' && ch <= '9';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
