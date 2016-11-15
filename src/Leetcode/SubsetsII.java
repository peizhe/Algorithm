package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for(int i = 0;i < nums.length;i ++){
        	List<List<Integer>> temp = new ArrayList<List<Integer>>();
        	
        	for(List<Integer> a : result){
        		temp.add(new ArrayList<Integer>(a));
        	}
        	
        	for(List<Integer> a : temp){
        		List<Integer> tep = new ArrayList<Integer>(a);
        		tep.add(nums[i]);
        		result.add(tep);
        	}
        }
        
        Set<List<Integer>> s = new HashSet<List<Integer>>();
        for(List<Integer> l : result){
        	s.add(new ArrayList<Integer>(l));
        }
        result = new ArrayList<List<Integer>>();
        
        for(List<Integer> l : s){
        	result.add(l);
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,2};
		subsetsWithDup(a);
	}
}
