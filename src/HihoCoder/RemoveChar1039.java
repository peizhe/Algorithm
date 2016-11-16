package HihoCoder;

import java.util.Scanner;
import java.util.Stack;

public class RemoveChar1039 {
	
	public static int getMax(String s) {
		if(s == null || s.length() <= 1) {
			return 2 * s.length();
		}
		
		char[] ch = s.toCharArray();
		int len = ch.length;
		StringBuilder sb = new StringBuilder();
		
		int score = 0;
		boolean isMoreThanTwo = false;
		
		Stack<Character> stack = new Stack<Character>();
		stack.add(ch[0]);
		
		for(int i = 1; i < len; i++) {
			if (ch[i] == stack.peek()) {
				isMoreThanTwo = true;
				score ++;
				
				if(i == len - 1) {
					score ++;
					stack.pop();
				}
			} else {//当前字符和前面字符不相同
				if(isMoreThanTwo) {
					stack.pop();
					score ++;
				} else {
					stack.push(ch[i]);
				}
				
				i --;
				isMoreThanTwo = false;
			}
		}
		
		if(stack.isEmpty()) return score + 1;
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		String res = sb.toString();
		int size = res.length();
		
		int tempScore = 0;
		for(int i = 0; i < size; i++) {
			int currentLen = parLen(s, i, i); 
			if(currentLen > tempScore) {
				tempScore = currentLen;
			}
		}
		
		return score + tempScore; 
	}
	
	/**
	 * 获得回文子串的长度
	 * 
	 * @param s
	 * @return
	 */
	private static int parLen(String s, int i, int j) {
		int length = 0;
		while(i >= 0 && j <= s.length()) {
			if(s.charAt(i) == s.charAt(j)) {
				length += 2;
			} else {
				return length;
			}
			
			i --;
			j ++;
		}
		
		//因为第一次判断的时候,length + 2,应该是length + 1
		return length - 1;
	}
    
    public static void main(String[] mh) {
        Scanner sc = Sc.sc;
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for(int i = 0; i < n; i++) {
                strs[i] = sc.next();
            }
            
            for(int i = 0; i < n; i++) {
            	System.out.println(getMax(strs[i]));
            }
        }
    }

}
