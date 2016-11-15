package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * �� mapʵ�ֵ�Ͱ
 * 	LeetCode-220(��������һ��˼·)
 * 
 * @author MG
 *
 */
public class MapBucket {

	/**
	 * Bucket ��ʽʵ�ֵ�
	 * 	(����һ���㷨��Ƶ�˼�룬��ס����˼��)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicateBucket220(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
        	//�������ת������������Ȼ����������ָ���
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)//map ��֤���±����K֮��
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)//����ǰһ��Ͱ��()������ֵ���<=t
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))//������һ��Ͱ�У�����ֵ���<=t
                            return true;
            
            if (map.entrySet().size() >= k) {//��Ͱ>=Kʱ���Ƴ���ǰ��nums[i - k]��Ӧ��Ͱ��Ԫ��
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            
            //�������map.put(1,4)��map.put(1,6)����,��Ϊ�������֤������Ͱ1�У�������ֱ�ӷ���true��
            map.put(bucket, remappedNum);
        }
        
        return false;
    }
}
