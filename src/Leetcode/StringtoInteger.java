package Leetcode;

public class StringtoInteger {
	public int myAtoi(String str) {
        String str1 = str.trim();
        if(str1.length() == 0)
        {
        	return 0;
        }
        char[] str2 = str1.toCharArray();
        char ch = str2[0];
        if(!((ch >= '0' && ch <= '9') || (ch == '-') || (ch == '+')))
        {
        	return 0;
        }
        
        int temp1 = str2.length;
        for(int i = 1;i < str2.length;i ++)
        {
        	if(!(str2[i] >= '0' && str2[i] <= '9'))
        	{
        		temp1 = i;
        		break;
        	}
        }
        if(ch == '-')
        {
        	int index = 1;
        	for(;index < temp1;index ++)
        	{
        		if(str2[index] != '0')
        		{
        			break;
        		}
        	}
        	if(index == temp1)
        	{
        		return 0;
        	}
        	String temp = str1.substring(index,temp1);
        	if(temp.length() > 11)
        	{
        		return -2147483648;
        	}
        	return (new Long("-" + temp) < Integer.MIN_VALUE) ? -2147483648 : new Integer("-" + temp); 
        }
        else if(ch == '+')
        {
        	int index = 1;
        	for(;index < temp1;index ++)
        	{
        		if(str2[index] != '0')
        		{
        			break;
        		}
        	}
        	if(index == temp1)
        	{
        		return 0;
        	}
        	if(str1.substring(1,temp1).length() > 11)
        	{
        		return 2147483647;
        	}
        	return (new Long(str1.substring(1,temp1)) > Integer.MAX_VALUE) ? 2147483647 : new Integer(str1.substring(1,temp1)); 
        }
        else
        {
        	int index = 0;
        	for(;index < temp1;index ++)
        	{
        		if(str2[index] != '0')
        		{
        			break;
        		}
        	}
        	if(index == temp1)
        	{
        		return 0;
        	}
        	if(str1.substring(0,temp1).length() > 11)
        	{
        		return 2147483647;
        	}
        	return (new Long(str1.substring(0,temp1)) > Integer.MAX_VALUE) ? 2147483647 : new Integer(str1.substring(0,temp1));
        }
    }
	public static void main(String[] mh)
	{
		StringtoInteger sti = new StringtoInteger();
		System.out.println(sti.myAtoi("2147483648"));
	}
}
