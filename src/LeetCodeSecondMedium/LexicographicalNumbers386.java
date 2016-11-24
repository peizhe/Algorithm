package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
	
	public List<Integer> lexicalOrder(int n) {
        if(n < 1) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 1; i < 10; i++) {
        	helper(res, i, n);
        }
        
        return res;
    }
	
	private void helper(List<Integer> res, int current, int n) {
		if(current > n) return;
		
		res.add(current);
		for(int i = 0; i < 10; i++) {
			//这句话很关键
			if(current * 10 + i > n) break;
			
			helper(res, current * 10 + i, n);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
