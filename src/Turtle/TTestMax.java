package Turtle;
//1046 输入10个数，要求输出其中的最大值。
import java.io.*;
import java.util.*;


public class TTestMax {
	public static void main(String[] mh) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String[] str;
		List<ArrayList<Integer>> ls = new ArrayList<ArrayList<Integer>>();
		do
		{
			s = br.readLine();
			if(s.equals(""))
			{
				break;
			}
			str = s.split(" ");
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0;i < str.length;i ++)
			{
				temp.add(Integer.parseInt(str[i]));
			}
			ls.add(temp);
		}while(true);
		for(int j = 0;j < ls.size();j ++)
		{
			int max = ls.get(j).get(0);
			for(int k = 1;k < 10;k ++)
			{
				if(ls.get(j).get(k) > max)
				{
					max = ls.get(j).get(k);
				}
			}
			System.out.println(max);
		}
	}
}
