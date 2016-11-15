package Leetcode;
import java.util.*;

public class MajorityElement {
	public int majorityElement(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0;i < nums.length;i++ ) {
	        if(count == 0){
	            result = nums[i];
	            count = 1;
	        } else if(result == nums[i]) {
	           count ++;
	        } else{
	           count --;
	        }
	    }
	 
	    return result;
	}
	
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		
		return nums[nums.length / 2];
	}
	
	public static void main(String[] mh){
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(2);
		ls.add(2);
		ls.add(2);
		ls.remove(new Integer(2));
		
		for(Integer i : ls){
			System.out.print(i + " ");
		}
	}
}
