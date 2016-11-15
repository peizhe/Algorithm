package Leetcode;
import java.util.ArrayList;
public class StrStr {
	public int strStr(String haystack, String needle) {
        int result = -1;
        if(haystack.equals(""))
        {
        	if(needle.equals(""))
        	{
        		return 0;
        	}
        	else
        		return -1;
        }
        else
        {
        	if(needle.equals(""))
        	{
        		return 0;
        	}
        }
        
        ArrayList<Integer> ls = new ArrayList<Integer>();
        char ch = needle.charAt(0);
        char[] hays = haystack.toCharArray();
        for(int i = 0;i < hays.length - needle.length() + 1;i ++)
        {
        	if(hays[i] == ch)
        	{
        		ls.add(i);
        	}
        }
       
        for(int i = 0;i < ls.size();i ++)
        {
        	int index = ls.get(i);
        	String temp = haystack.substring(index, index + needle.length());
        	if(temp.equals(needle))
        	{
        		result = index;
        		break;
        	}
        }
        return result;
    }
	public static void main(String[] mh)
	{
		StrStr ss = new StrStr();
		System.out.println(ss.strStr("hello", "lll"));
	}
}
