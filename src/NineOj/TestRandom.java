package NineOj;

import java.util.*;

public class TestRandom {
	public static ArrayList<Double> randomPro(int n)
	{
		ArrayList<Double> ls = new ArrayList<Double>();
		for(int i = 0;i < n;i ++)
		{
			Double temp1 = Math.random() * 8 - 4;
			ls.add(temp1);
		}
		return ls;
	}
	public static void main(String[] mh)
	{
		ArrayList<Double> ls = new ArrayList<Double>();
		ls = randomPro(15);
		for(int i = 0;i < ls.size();i ++)
		{ 
			System.out.print(ls.get(i) + " ");
		}
	}
}
