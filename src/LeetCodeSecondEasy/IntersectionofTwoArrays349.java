package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 求两个数组的交集：
 * 	1.使用set作为辅助空间进行
 *  2.将两个数组进行排序，双指针
 *  3.在一个数组中查找另一个数组中出现的数字
 *  4.java 8两句话可以搞定(过滤器的使用)
 * @author MG
 *
 */
public class IntersectionofTwoArrays349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
        	return new int[]{};
        }
        
        
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        for(int i = 0;i < length1;i ++){
        	set.add(nums1[i]);
        }
        
        for(int i = 0;i < length2;i ++){
        	if(set.contains(nums2[i])){
        		res.add(nums2[i]);
        		set.remove(nums2[i]);
        	}
        }
        int[] result = new int[res.size()];
        
        for(int i = 0;i < res.size();i ++){
        	result[i] = res.get(i);
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
