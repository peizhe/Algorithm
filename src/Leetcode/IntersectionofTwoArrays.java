package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
			return new int[0];
		}
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		
		int nums1Len = nums1.length;
		int nums2Len = nums2.length;
		
        for(int i = 0;i < nums1Len;i ++){
        	set.add(nums1[i]);
        }
        
        for(int j = 0;j < nums2Len;j ++){
    		if(set.contains(nums2[j])){
    			temp.add(nums2[j]);
    			set.remove(nums2[j]);
    		}
    	}
        
        int[] res = new int[temp.size()];
        
        int j = 0;
        for(Integer i : temp){
        	res[j ++] = i;
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,3,4};
		int[] nums2 = {2,2,5,3};
		
		int[] res = new IntersectionofTwoArrays().intersection(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
}
