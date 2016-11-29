package LeetCodeSecondMedium;

public class IncreasingTripletSubsequence334 {

	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i : nums) {
        	if(i <= first) {
        		first = i;
        	} else if(i <= second) {
        		second = i;
        	} else {
        		return true;
        	}
        }
        
        return false;
    }
}
