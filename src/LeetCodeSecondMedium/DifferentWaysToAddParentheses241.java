package LeetCodeSecondMedium;

import java.util.List;
import java.util.ArrayList;

public class DifferentWaysToAddParentheses241 {
	
	public List<Integer> diffWaysToCompute(String input) {
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
		
		return new ArrayList<>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
