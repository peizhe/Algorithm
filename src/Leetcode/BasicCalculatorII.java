package Leetcode;

import java.util.Stack;

public class BasicCalculatorII {
	
	public int calculate1(String s) {
		int result = 0;
		int len = s.length();
		Stack<Character> opterator = new Stack<Character>();
		Stack<Integer> number = new Stack<Integer>();
		opterator.push('+');
		
		for(int i = 0;i < len;){
			char ch = s.charAt(i);
			if(isOperator(ch)){
				opterator.push(ch);
				i ++;
			}
			else if(ch == ' '){
				i ++;
			}		
			else{
				int right = 0;
				while(i < len && isNumber(s.charAt(i))){
					right = 10 * right + s.charAt(i) - '0';
					i ++; 
				}
				
				if(!opterator.isEmpty() && (opterator.peek() == '*' || opterator.peek() == '/')){
					right = helpCalculate(number.pop(), opterator.pop(), right);
				}
				number.push(right);
			}
		}
		
		while(!opterator.isEmpty()){
			int temp = number.peek();
			if(opterator.peek() == '-'){
				temp = -temp;
			}
			result += temp;
			number.pop();
			opterator.pop();
		}

		return result;
	}
	
	public int helpCalculate(int top,char operator,int current){
		int result = 0;
		switch (operator) {
			case '*':
				result = top * current;
				break;
			case '/':
				result = top / current;
				break;
			default:
				return 0;
		}
		return result;
	}
	
	private boolean isOperator(char ch){
		return ch == '+' || ch == '-' || ch== '*' || ch == '/'; 
	}
	
	private boolean isNumber(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "1*2-3/4+5*6-7*8+9/10";
//		calculate1(s);
	}

}
