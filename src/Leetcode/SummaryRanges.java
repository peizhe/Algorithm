package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		int start = 0,end = 0;
        for(int i = 0;i <= nums.length - 1;i ++){
        	if(i == nums.length - 1){
        		String temp = "";
        		if(start < i){
        			temp = nums[start] + "->" + nums[i];
        		}
        		else{
        			temp = nums[i] + "";
        		}
        		result.add(temp);
        	}
        	else{
        		if(nums[i] == nums[i + 1] - 1){
            		end = i + 1;
            	}
            	
            	else{
            		String temp = "";
            		if(start < end){
            			temp = nums[start] + "->" + nums[end];
            		}
            		else{
            			temp = nums[end] + "";
            		}
            		result.add(temp);
            		start = end + 1;
            		end = start;
            	}
        	}
        }
        
        return result;
    }

}
