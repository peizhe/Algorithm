package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArraysII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
			return new int[0];
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int nums1Len = nums1.length,nums2Len = nums2.length;
		int i = 0,j = 0;
		List<Integer> temp = new ArrayList<Integer>();
		while(i < nums1Len && j < nums2Len){
			if(nums1[i] < nums2[j]){
				i ++;
			}
			else if(nums1[i] > nums2[j]){
				j ++;
			}
			else{
				temp.add(nums1[i]);
				i ++;
				j ++;
			}
		}
		
        int[] res = new int[temp.size()];
        int k = 0;
        for(Integer x : temp){
        	res[k ++] = x;
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,3,4};
		int[] nums2 = {2,2,2,5,3};
		
		int[] res = new IntersectionofTwoArraysII().intersect(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
}
