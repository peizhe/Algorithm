package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
	public List<Integer> grayCode(int n) {
        if(n <= 0) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        
        return helper(res, 0, n);
    }	
	
	private List<Integer> helper(List<Integer> res, int current, int n) {
		if(current > n) {
			return res;
		}
		
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = res.size() - 1; i >= 0; i--) {
			temp.add(res.get(i) + 1 << current);
		}
		
		res.addAll(temp);
		
		return helper(res, current + 1, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
