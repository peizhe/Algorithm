package LeetCodeSecondMedium;

import java.util.List;
import java.util.ArrayList;

public class Combinations77 {
	public List<List<Integer>> combine(int n, int k) {
        if(n < 1 || k < 1) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, new ArrayList<Integer>(), n, 1, k);
        
        return res;
    }
	
	private void helper(List<List<Integer>> res, List<Integer> temp, int n, int current, int k) {
		if(temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for(int i = current; i <= n; i++) {
			temp.add(i);
			helper(res, temp, n, i + 1, k);
			temp.remove(temp.size() - 1);
		}
	}
}
