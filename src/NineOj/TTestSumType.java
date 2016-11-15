package NineOj;
//1072：有多少不同的面值组合？

import java.util.*;

public class TTestSumType 
{
	public static void main(String[] mh)
	{
		int[][] a = {{8,5},{10,4},{18,6}};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for(int i = 0;i <= a[0][0];i ++)
		{
			for(int j = 0;j <= a[1][0];j ++)
			{
				for(int k = 0;k <= a[2][0];k ++)
				{
					int temp = i * 8 + j * 10 + 18 * k,m;
					for(m = 0;m < ls.size();m ++)
					{
						if(temp == ls.get(m))
						{
							break;
						}
					}
					if(m == ls.size())
					{
						ls.add(temp);
					}
				}
			}
		}
		for(int i = 0;i < ls.size();i ++)
		{
			System.out.print(ls.get(i) + " ");
		}
		System.out.println();
		System.out.println(ls.size());
	}
}
