package Leetcode;

public class LongestIncreasingSubsequence {
	//动态规划的思想，要想到呀，这么笨怎么行
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int[] res = new int[nums.length];
		int max = 1;
		for(int i = 0;i < nums.length;i ++){
			res[i] = 1;
			for(int j = 0;j < i;j ++){
				if(nums[i] > nums[j]){
					res[i] = Math.max(res[i], res[j] + 1);
				}
			}
			if(res[i] > max){
				max = res[i];
			}
		}
		
		return max;
    }
	
	//第二种方法 二分查找的方法
	public int longestIncreasingSubsequence(int[] nums) {
        int[] minLast = new int[nums.length + 1];
        minLast[0] = -1;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast > nums[i]
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }
        
        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        
        return 0;
    }
    
    // find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] == num) {
                start = mid;
            } 
            else if (minLast[mid] < num) {
                start = mid;
            } 
            else {
                end = mid;
            }
        }
        
        if (minLast[start] > num) {
            return start;
        }
        return end;
    }
}
