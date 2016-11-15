package Leetcode;
import java.util.ArrayList;


public class HappyNumber {
	//数论的知识，有点不懂
	public boolean isHappy1(int n){
		while(n > 6){
	        int next = 0;
	        while(n > 0){
	        	next += (n % 10) * (n % 10); 
	        	n /= 10;
	        }
	        n = next;
	    }
	    return n == 1;
	}
	
	public boolean isHappy(int n) {
        if(n < 1)
        {
        	return false;
        }
        if(n == 1)
        {
        	return true;
        }
        ArrayList<Integer> store = new ArrayList<Integer>();
        int temp = cal(n);
        store.add(n);
        while(true)
        {
        	if(temp == 1)
        	{
        		return true;
        	}
        	else if(store.contains(temp))
        	{
        		return false;
        	}
        	else
        	{
        		store.add(temp);
        	}
        	temp = cal(temp);
        }
    }
	
	public int cal(int x)
	{
		int res = 0;
		int mod = x % 10;
		int last = x / 10;
		while(mod != 0 || last != 0)
		{
			res = res + mod * mod;
			mod = last % 10;
			last = last /10;
		}
		return res;
	}
	public static void main(String[] mh)
	{
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(2));
	}
}
