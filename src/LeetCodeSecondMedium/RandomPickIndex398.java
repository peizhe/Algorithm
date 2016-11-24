package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class RandomPickIndex398 {
	
	private Map<Integer, List<Integer>> map;
	private Random random;
	
	public RandomPickIndex398(int[] nums) { 
		map = new HashMap<Integer, List<Integer>>();
		random = new Random();
		
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<Integer>());
			}
			
			map.get(nums[i]).add(i);
		}
	}
	
	public int pick(int target) {
		List<Integer> list = map.get(target); 
		return list.get(random.nextInt(list.size()));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
