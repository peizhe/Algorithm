package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII220 {
	/**
	 * ��ֱ�ӵķ��� :
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
	 * Bucket ��ʽʵ�ֵ�
	 * 	(����һ���㷨��Ƶ�˼�룬��ס����˼��)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
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
	
	/**
	 * TreeSet ʵ�ֵķ�ʽ
	 * 	��TreeSet ʵ�ֺܼ�(��TreeSet������һ����������)
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
        	
        	//����С��nums[ind] + t ��Ԫ��
            final Integer floor = values.floor(nums[ind] + t);
            //���Ҵ���nums[ind] - t ��Ԫ��
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
