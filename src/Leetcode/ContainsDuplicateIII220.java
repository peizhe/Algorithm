package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII220 {
	/**
	 * 最直接的方法 :
	 * 	
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length == 0 || k <= 0){
			return false;
		}
		int len = nums.length;
		long temp = 0;
		
		for(int i = 1;i < len;i ++){
			int j = Math.max(i - k, 0);
			for(;j < i;j ++){
				temp = (nums[i] - nums[j]); 
				if(Math.abs(temp) <= t){
					return true;
				}
			}
		}
		
		return false;
    }
	
	/**
	 * Bucket 方式实现的
	 * 	(这是一种算法设计的思想，记住这种思想)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
        	//将这个数转换成正数，不然做除法会出现负数
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)//map 保证了下标差在K之内
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)//在它前一个桶中()，但是值差别<=t
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))//在它后一个桶中，但是值差别<=t
                            return true;
            
            if (map.entrySet().size() >= k) {//当桶>=K时，移除最前面nums[i - k]对应的桶的元素
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            
            //不会出现map.put(1,4)和map.put(1,6)这种,因为如果这样证明都在桶1中，在上面直接返回true了
            map.put(bucket, remappedNum);
        }
        
        return false;
    }
	
	/**
	 * TreeSet 实现的方式
	 * 	用TreeSet 实现很简单(将TreeSet看做是一个滑动窗口)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<Integer>();
        for (int ind = 0; ind < nums.length; ind++) {
        	
        	//查找小于nums[ind] + t 的元素
            final Integer floor = values.floor(nums[ind] + t);
            //查找大于nums[ind] - t 的元素
            final Integer ceil = values.ceiling(nums[ind] - t);
            
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
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
