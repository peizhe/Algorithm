package Turtle;
//1048 ���������ε������ߣ�a,b,c���жϸ����������͡�
import java.io.*;
import java.util.*;

public class TTestAn {
	public static void main(String[] mh) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<ArrayList<Integer>> save = new ArrayList<ArrayList<Integer>>();
		String str;
		do{		
			str = br.readLine();
			if(str.equals(""))
			{
				break;
			}
			else
			{
				String[] s1 = str.split(" ");
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(Integer.parseInt(s1[0]));
				temp.add(Integer.parseInt(s1[1]));
				temp.add(Integer.parseInt(s1[2]));
				save.add(temp);
			}
		  }while(true);
		
		for(int i = 0;i < save.size();i ++)
		{
			int a,b,c;
			a = save.get(i).get(0);
			b = save.get(i).get(1);
			c = save.get(i).get(2);			
			if(a + b <= c || a + c <= b ||b + c <= a)
			{
				System.out.println("���ܹ���������");
			}
			else
			{
				if(a * a == b * b + c * c || b * b == a * a + c * c || c * c == b * b + a * a)
				{
					System.out.println("ֱ��������");
				}
				else if(a * a > b * b + c * c || b * b > a * a + c * c || c * c > b * b + a * a)
				{
					System.out.println("�۽�������");
				}
				else
					System.out.println("���������");
			}
		}
	}
}
