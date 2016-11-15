package Leetcode;

public class PrimeNumbers {
	public int countPrimes(int n) {
		if(n <= 2)
		{
			return 0;
		}
		int res = 1;
		int n1 = n - 1;
		for(int i = 3;i <= n1;i = i + 2)
		{
			if(isS(i))
			{
				res ++;
			}
		}
		
		return res;
	}
	
	public boolean isS(int x)
	{
		if(x == 3){
			return true;
		}
		int i = 3;
		int temp = (int)Math.sqrt(x) + 1;
		for(;i < temp;i = i + 2)
		{
			if(x % i == 0)
			{
				return false;
			}
		}
		
		if(i == temp || i == temp + 1)
		{
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] mh)
	{
		PrimeNumbers pn = new PrimeNumbers();
		System.out.println(pn.countPrimes(14));
	}
}
