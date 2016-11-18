package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
        if(n < 1) {
        	return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<String>();
        
        for(int i = 1; i <= n; i++) {
        	int flag = 1;
        	if(i % 5 == 0) {
        		flag = 5;
        	}
        	
        	if(i % 3 == 0) {
        		flag = flag == 5 ? 15 : 3;
        	}
        	
        	res.add(flag == 3 ? "Fizz" : flag == 5 ? "Buzz" : flag == 15 ? "FizzBuzz" : i + "");
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
