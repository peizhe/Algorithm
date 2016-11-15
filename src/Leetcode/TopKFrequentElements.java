package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements{
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        int len = nums.length;
        for(int i = 0;i < len;i ++){
        	if(temp.containsKey(nums[i])){
        		temp.put(nums[i], temp.get(nums[i]) + 1);
        	}
        	else{
        		temp.put(nums[i], 1);
        	}
        }
       
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
        for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
        	list.add(entry);
        }
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        	//从大到小排序
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				if(o1.getValue() > o2.getValue()){
					return -1;
				}
				else if(o1.getValue() < o2.getValue()){
					return 1;
				}
				else{
					return 0;
				}
			}
		});
        
        for(int i = 0;i < k;i ++){
        	res.add(list.get(i).getKey());
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,3,1,1,1};
		int k = 2;
		List<Integer> ls = new TopKFrequentElements().topKFrequent(nums, k);
		System.out.println(Arrays.toString(ls.toArray()));
	}
}
