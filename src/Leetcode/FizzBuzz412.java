package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		if (n <= 0) {
			return new ArrayList<String>();
		}

		List<String> res = new ArrayList<String>();
		
		// 1����3�ı�����2����5�ı�����3�������3�ı���Ҳ��5�ı���
		int[] flag = new int[n + 1];
		int i = 3,j = 5;
		for(;i <= n || j <= n; i += 3,j += 5){
			if(j <= n) flag[j] = 2;
			
			flag[i] = flag[i] == 2 ? 3 : 1;
		}
		
		for(i = 1;i <= n; i++){
			if(flag[i] == 0){
				res.add(i + "");
			} else if(flag[i] == 1){
				res.add("Fizz");
			} else if(flag[i] == 2){
				res.add("Buzz");
			} else {
				res.add("FizzBuzz");
			} 
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
