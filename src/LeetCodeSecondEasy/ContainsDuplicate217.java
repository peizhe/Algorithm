package LeetCodeSecondEasy;

import java.util.HashSet;
import java.util.Set;
/**
 * 判断数组中是否有重复元素
 * 	1.set方法
 *  2.map方法
 *  3.排序，比较相邻元素
 *  (使用set，map等数据结构会影响性能)
 * @author MG
 *
 */
public class ContainsDuplicate217 {
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length <= 1){
			return false;
		}
		
        Set<Integer> set = new HashSet<Integer>();
        for(Integer i : nums){
        	set.add(i);
        }
        
        return !(nums.length == set.size());
    }
	
	//网友自己实现的hash表，击败97%
	public boolean containsDuplicate1(int[] nums) {
		int n = nums.length;
	    boolean[] exists = new boolean[n];
	    int[] entries = new int[n];
	    for (int num : nums) {
	        int hash = Math.abs(num) % n;
	        // look up hash
	        int index = hash + 0;
	        while (exists[index] && entries[index] != num) {
	            index = (index + 1) % n; // open addressing
	        }
	        if (exists[index]) { // contains(num)
	            return true;
	        } else { // add(num)
	            exists[index] = true;
	            entries[index] = num;
	        }
	    }
	    return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
