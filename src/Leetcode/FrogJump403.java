package Leetcode;

import java.util.*;
/**
 * 效率有点低
 * 
 * @author MG
 *
 */
public class FrogJump403 {
	public static boolean canCross(int[] stones) {
		if(stones == null || stones.length < 2){
			return true;
		}
		
		//键为石头的位置，值为在该石头上可以向前跳的所有可能的步的集合
		Map<Integer,Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		int len = stones.length;
		for(int i : stones){
			map.put(i, new HashSet<Integer>());
		}
		
		if(stones[0] + 1 == stones[1]){
			map.get(stones[1]).add(1);
		}
		
		for(int i = 1;i < len;i ++){
			int stone = stones[i];
						
			for(int step : map.get(stone)){
				if(step > 1 && map.containsKey(stone + step - 1)){
					map.get(stone + step - 1).add(step - 1);
				}
				
				if(map.containsKey(stone + step)){
					map.get(stone + step).add(step);
				}
				
				if(map.containsKey(stone + step + 1)){
					map.get(stone + step + 1).add(step + 1);
				}
			}
		}
		
        return map.get(stones[len - 1]).size() == 0 ? false : true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0,1,3,5,6,8,12,17};
		System.out.println(canCross(nums));
	}

}
