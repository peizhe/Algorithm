package LeetCodeSecondEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 查找数组中是否存在nums[i] == nums[j] 并且j - i >= k
 * 	1.两层循环搞定(时间复杂度有点高)O(n ^ 2)
 * 	2.使用Map，键是数组元素，值为数组中第一次出现的下标(时间复杂度为O(n)，空间复杂度为O(n),运用了复杂数据结构，效率感觉不高)
 *  3.计数排序的思想，自己设计map(时间效率很高)
 *  4.网友使用set实现的
 * @author MG
 *
 */
public class ContainsDuplicateII219 {
	//滑动窗口的形式
	public boolean containsNearbyDuplicateSecond(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) 
            	set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) 
            	return true;
        }
        
        return false;
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(null == nums || nums.length == 0){
			return false;
		}
		
		int min = nums[0],max = nums[0],len = nums.length;
		
		for(int i = 1;i < len;i ++){
			if(nums[i] < min){
				min = nums[i];
			}
			
			if(nums[i] > max){
				max = nums[i];
			}
		}
		
		//存储第一次出现的下标
		int[] map = new int[max - min + 1];
		Arrays.fill(map, -1);
		
		int temp;
		for(int i = 0;i < len;i ++){
			temp = nums[i] - min;
			if(map[temp] == -1){
				map[temp] = i;
				continue;
			}
			
			if(i - map[temp] <= k){
				return true;
			}else{
				map[temp] = i;
			}
		}
		
		return false;
	}
}
