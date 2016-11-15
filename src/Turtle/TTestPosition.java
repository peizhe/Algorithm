package Turtle;
//1052£∫’“x
import java.util.*;
import java.io.*;



public class TTestPosition {
	public static void main(String[] mh) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> ls = new ArrayList<String>();
		String[] str;
		String s;
		do
		{
			s = br.readLine();
			if(s.equals(""))
			{
				break;
			}
			else
			{
				ls.add(s);
			}
		}while(true);
		
		for(int i = 0;i < ls.size(); i ++)
		{
			str = ls.get(i).split(" ");
			for(int j = 1;j < str.length - 1;j ++)
			{
				if(str[j].compareTo(str[str.length - 1]) == 0)
				{
					System.out.println(j);
					break;
				}
			}
		}
	}
}
