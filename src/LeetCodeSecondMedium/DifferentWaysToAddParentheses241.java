package LeetCodeSecondMedium;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DifferentWaysToAddParentheses241 {
	
	public static List<Integer> diffWaysToCompute(String input) {
		if(input == null || input.length() == 0) return new ArrayList<Integer>();
		
		List<Integer> nums = new ArrayList<Integer>();
		List<Character> opterator = new ArrayList<Character>();
		
		int len = input.length(), temp = -1;
		
		//预处理，将数字和运算符分解出来
		for(int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*') {
				opterator.add(ch);
				if(temp != -1) { 
					nums.add(temp);
					temp = -1;
				}
			} else if (ch >= '0' && ch <= '9'){
				if(temp == -1) temp = 0;
				temp *= 10;
				temp += ch - '0';
			}
		}
		
		nums.add(temp);
		
		return divide(nums, opterator, 0, opterator.size());
	}
	
	private static List<Integer> divide(List<Integer> nums, List<Character> opterators, int begin, int end) {
		if(begin == end) {
			return Collections.singletonList(nums.get(begin));
		} else if (begin + 1 == end){
			return Collections.singletonList(getRes(nums.get(begin), nums.get(end), opterators.get(begin)));
		} else {
			List<Integer> res = new ArrayList<>();
			
			for(int i = begin; i < end; i++) {
				List<Integer> left = divide(nums, opterators, begin, i);
				List<Integer> right = divide(nums, opterators, i + 1, end);
				
				for(int m : left) {
					for(int n : right) {
						res.add(getRes(m, n, opterators.get(i)));
					}
				}
			}
			
			return res;
		}
	}
	
	private static int getRes(int a, int b, char optertor) {
		switch(optertor) {
			case '-' : return a - b;
			case '+' : return a + b;
			case '*' : return a * b;
		}
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2-1-1";
		System.out.println(diffWaysToCompute(s));
	}

}
