package LeetCodeSecondEasy;

import java.util.Stack;
/**
 * �ж������Ƿ�ƥ�䣺
 * 	1.ʹ��ϵͳջʵ�֣��Ƚ���
 * 	2.�Լ����ջ���ȽϿ�(�Ƽ�)
 * @author MG
 *
 */
public class ValidParentheses20 {
	public boolean isValidBetter(String s){
		if(s == null || s.length() == 0){
			return true;
		}
		
		int len = s.length();
		char[] ch = s.toCharArray();
		char[] st = new char[len];
		//ջ��ָ��
		int top = 0;
		char temp;
		for(int i = 0;i < len;i ++){
			temp = ch[i];
			if(temp == '(' || temp == '{' || temp == '['){
				st[top ++] = temp;
				continue;
			}
			
			if(top == 0){
				return false;
			} 
			
			char c = st[-- top];
			if(c == '(' && temp == ')' || c == '[' && temp == ']' || c == '{' && temp == '}'){
				continue;
			} else{
				return false;
			}
		}
		
		return top == 0;
	}
	
	public boolean isValid(String s) {
		if(s == null || s.length() == 0){
			return true;
		}
		int len = s.length();
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i < len;i ++){
			if(stack.isEmpty()){
				stack.push(ch[i]);
				continue;
			}
			
			char temp = stack.peek();
			
			if(confirmValid(temp, ch[i])){
				stack.pop();
			}else{
				stack.push(ch[i]);
			}	
		}
		return stack.isEmpty();
    }
	
	private boolean confirmValid(char origin,char des){
		switch(origin){
			case '(':
				if(des == ')') return true;
			case '[':
				if(des == ']') return true;
			case '{':
				if(des == '}') return true;
			default:
				return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
