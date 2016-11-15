package Leetcode;

import java.util.*;

public class ThirdMaximumNumber414 {
	
	/**
	 * 使用循环的方式:
	 * 	时间复杂度O(n),空间复杂度O(1)
	 * @param nums
	 * @return
	 */
	public int thirdMaxBetter(int[] nums) {
        int max, mid, small, count;
        max = mid = small = Integer.MIN_VALUE;
        count = 0;  //Count how many top elements have been found.

        for(int x: nums) {
            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
            if( x == max || x == mid ) {
                continue;
            }

            if (x > max) {
                //right shift
                small = mid;
                mid = max;

                max = x;
                count ++;
            } else if(x > mid) {
                //right shift
                small = mid;

                mid = x;
                count ++;
            } else if (x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
                small = x;
                count ++;
            }
        }

        //"count" is used for checking whether found top 3 maximum elements.
        if( count >= 3) { 
            return small;
        } else {
            return max;
        }
    }
	
	/**
	 * 使用3次寻找最大值的方法
	 * @param nums
	 * @return
	 */
	public static int thirdMax(int[] nums) {
        if(nums == null || nums.length < 1){
        	return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums){
        	set.add(i);
        }
        
        int index = 0;
        nums = new int[set.size()];
        
        for(int i : set){
        	nums[index ++] = i;
        }
        
        int len = nums.length;
        if(len == 1){
        	return nums[0];
        } else if(len == 2){
        	return nums[0] > nums[1] ? nums[0] : nums[1];
        } else {
        	int maxIndex = 0;
        	for(int i = 0;i < 3;i ++){
        		maxIndex = 0;
        		for(int j = 1;j < len;j ++){
        			if(nums[j] > nums[maxIndex]){
        				maxIndex = j;
        			}
        		}
        		if(i != 2){
        			nums[maxIndex] = Integer.MIN_VALUE;
        		}
        	}
        	
        	return nums[maxIndex];
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,2,5,3,5};
		System.out.println(thirdMax(nums));
	}

}
