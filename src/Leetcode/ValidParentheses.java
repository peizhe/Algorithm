package Leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        char[] ch = s.trim().toCharArray();
        Stack<Character> st = new Stack<Character>();
        st.push(ch[0]);
        for(int i = 1;i < ch.length;i ++){
        	char temp = ch[i];
        	if(temp == ' ')
        	{
        		continue;
        	}
        	else if(temp == ')')
        	{
        		if(st.isEmpty())
        		{
        			return false;
        		}
        		if(st.peek() == '(')
        		{
        			st.pop();
        		}
        		else
        		{
        			return false;
        		}
        	}
        	else if(temp == '}')
        	{
        		if(st.isEmpty())
        		{
        			return false;
        		}
        		if(st.peek() == '{')
        		{
        			st.pop();
        		}
        		else
        		{
        			return false;
        		}
        	}
        	else if(temp == ']')
        	{
        		if(st.isEmpty())
        		{
        			return false;
        		}
        		if(st.peek() == '[')
        		{
        			st.pop();
        		}
        		else
        		{
        			return false;
        		}
        	}
        	else
        	{
        		st.push(temp);
        	}
        }
        if(st.isEmpty())
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
	public static void main(String[] mh)
	{
		ValidParentheses vp = new ValidParentheses();
		String s = "[])";
		System.out.println(vp.isValid(s));
	}
}
