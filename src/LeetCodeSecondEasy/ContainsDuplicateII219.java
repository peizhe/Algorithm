package LeetCodeSecondEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * �����������Ƿ����nums[i] == nums[j] ����j - i >= k
 * 	1.����ѭ���㶨(ʱ�临�Ӷ��е��)O(n ^ 2)
 * 	2.ʹ��Map����������Ԫ�أ�ֵΪ�����е�һ�γ��ֵ��±�(ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(n),�����˸������ݽṹ��Ч�ʸо�����)
 *  3.���������˼�룬�Լ����map(ʱ��Ч�ʺܸ�)
 *  4.����ʹ��setʵ�ֵ�
 * @author MG
 *
 */
public class ContainsDuplicateII219 {
	//�������ڵ���ʽ
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
		
		//�洢��һ�γ��ֵ��±�
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
