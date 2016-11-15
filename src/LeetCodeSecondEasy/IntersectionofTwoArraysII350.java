package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
			return new int[]{};
		}
		List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int len1 = nums1.length,len2 = nums2.length;
        int index1 = 0,index2 = 0;
        while(index1 < len1 && index2 < len2){
        	if(nums1[index1] == nums2[index2]){
        		res.add(nums1[index1]);
        		index1 ++;
        		index2 ++;
        	}
        	else if(nums1[index1] > nums2[index2]){
        		index2 ++;
        	}
        	else{
        		index1 ++;
        	}
        }
        
        int[] result = new int[res.size()];
        int index = 0;
        for(int i : res){
        	result[index] = i;
        	index ++;
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
