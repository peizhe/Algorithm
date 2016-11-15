package Leetcode;

import java.util.ArrayList;
import java.util.List;


public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		if(n < 1 || k < 1){
			return "";
		}
		
		//				0,1,2,3,4 ,5  ,6  ,7   ,8
        int[] assist = {1,1,2,6,24,120,720,5040,40320};
        //存储1,2,3...n
        List<Integer> number = new ArrayList<Integer>();
        //初始化放在链表中
        for(int i = 0;i < n;i ++){
        	number.add(i + 1);
        }
        
        k --;
        String res = "";
        
        for(int i = n - 1;i >= 0;i --){
            int selected = k / assist[i];  
            res += number.remove(selected);    
            k %= assist[i];
        }
        
        return res;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int k = 8590;
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(n, k));
	}
}
