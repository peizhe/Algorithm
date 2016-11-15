package Leetcode;

import java.util.Stack;

public class BasicCalculator224 {
	public int calculate(String s) {
		if(s == null || s.trim().length() == 0){
			return 0;
		}
		
		char[] c = s.trim().toCharArray();
		int len = c.length;
		
		
		Stack<Character> operatorStack = new Stack<Character>();
		Stack<Integer> numberStack = new Stack<Integer>();
	
		//将数字全部存储起来
		for(int i = 0;i < len;){
			char ch = c[i];
			if(isOperator(ch)){
				if(ch == ')'){
					operatorStack.pop();
					while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
						int y = numberStack.pop();
						int x = numberStack.pop(); 
						numberStack.add(operate(x, y, operatorStack.pop()));
					}
				} else {
					operatorStack.add(ch);
				}
				i ++;
			} else if (ch == ' '){
				i ++;
			} else {
				int number = 0;
				while(i < len && isNumber(c[i])){
					number *= 10;
					number += c[i] - '0';
					i ++;
				}
				
				if(!operatorStack.isEmpty() && operatorStack.peek() != '('){
					number = operate(numberStack.pop(),  number, operatorStack.pop());
				}
				
				numberStack.add(number);
			}
		}
		
		return numberStack.peek();
    }
	
	
	private int operate(int x, int y, char operator){
		switch(operator){
			case '+':
				return x + y;
			case '-':
				return x - y;
			default :
				return 0;
		}
	}
	
	private boolean isOperator(char c){
		return c == '(' || c == ')' || c == '+' || c == '-';
	}
	
	private boolean isNumber(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
