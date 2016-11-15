package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 用 map实现的桶
 * 	LeetCode-220(解决问题的一种思路)
 * 
 * @author MG
 *
 */
public class MapBucket {

	/**
	 * Bucket 方式实现的
	 * 	(这是一种算法设计的思想，记住这种思想)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicateBucket220(int[] nums, int k, int t) {
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
}
