package LeetCodeSecondMedium;

public class WiggleSubsequence376 {
	public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int start = -1;
        
        boolean flag = false;
        for(int i = 1; i < len; i++) {
        	if(nums[i] != nums[i - 1]) {
        		start = i;
        		flag = nums[i] > nums[i - 1] ? true : false;
        		break;
        	}
        }
        
        if(start == -1) return 0;
        
        int res = 1;
        for(int i = start; i < len; i++) {
        	if(flag) {
        		if(nums[i] > nums[i - 1]) {
        			res++;
        			flag = !flag;
        		}
        	}
        	else {
        		if(nums[i] < nums[i - 1]) {
        			res++;
        			flag = !flag;
        		}
        	}
        }
        
        return res;
    }
}
