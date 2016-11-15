package LeetCodeSecondEasy;

import java.util.HashSet;
import java.util.Set;
/**
 * �ж��������Ƿ����ظ�Ԫ��
 * 	1.set����
 *  2.map����
 *  3.���򣬱Ƚ�����Ԫ��
 *  (ʹ��set��map�����ݽṹ��Ӱ������)
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
	
	//�����Լ�ʵ�ֵ�hash������97%
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
