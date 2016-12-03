package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;
/**
 * 和格雷码的生成很相似
 * 
 * @author MG
 *
 */
public class Subsets78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for(int i : nums) {
        	List<List<Integer>> newList = new ArrayList<>(res);
        	
        	for(List<Integer> list : res) {
        		List<Integer> temp = new ArrayList<>(list);
        		temp.add(i);
        		newList.add(temp);
        	}
        	
        	res = newList;
        }
        
        return res;
    }
}
