package Leetcode;

import java.util.Arrays;

public class WiggleSortII {
	
	public static final String name =  WiggleSortII.class.getName();
	
	public static void main(String[] mh){
		System.out.println(WiggleSortII.name);
	}
	
	
	//时间 O(NlogN) 空间 O(1)
	public void wiggleSort(int[] nums) {
        // 先将数组排序
        Arrays.sort(nums);
        // 将数组中一对一对交换
        for(int i = 2; i < nums.length; i+=2){
            int tmp = nums[i-1];
            nums[i - 1] = nums[i];
            nums[i] = tmp;
        }
    }
	
	/**
	 * 时间 O(N) 空间 O(1)
	 * 思路:题目对摇摆排序的定义有两部分：
	 * 如果i是奇数，nums[i] >= nums[i - 1]
	 * 如果i是偶数，nums[i] <= nums[i - 1]
	 * 所以我们只要遍历一遍数组，把不符合的情况交换一下就行了。
	 * 具体来说，如果nums[i] > nums[i - 1]， 则交换以后肯定有nums[i] <= nums[i - 1]。
	 * @param nums
	 */
	public void wiggleSort1(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            // 需要交换的情况：奇数时nums[i] < nums[i - 1]或偶数时nums[i] > nums[i - 1]
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for(int i = 0;i < nums.length - 1;i ++){
        	if((i & 1) == 0){
        		if(nums[i] >= nums[i + 1]){
        			System.out.println("no result");
        			break;
        		}
        	}
        	else{
        		if(nums[i] <= nums[i + 1]){
        			System.out.println("no res");
        			break;
        		}
        	}
        }
    }
}
