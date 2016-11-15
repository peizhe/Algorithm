package Turtle;
//1000  求整数a，b的和。
import java.io.*;
import java.util.*;


public class TTestab {
	public static void main(String[] mh)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		List<ArrayList<Long>> save = new ArrayList<ArrayList<Long>>();
		try{
			do{		
				str = br.readLine();
				if(str.equals(""))
				{
					break;
				}
				else
				{
					String[] s1 = str.split(" ");
					ArrayList<Long> temp = new ArrayList<Long>();
					temp.add(Long.parseLong(s1[0]));
					temp.add(Long.parseLong(s1[1]));
					save.add(temp);
				}
			}while(true);	
			
			for(int i = 0;i < save.size();i ++)
			{
				System.out.println(save.get(i).get(0) + save.get(i).get(1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
