package LeetCodeSecondEasy;

public class RemoveDuplicatesfromSortedArray26 {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0; 
		}
        int index = 0;
        int len = nums.length;
        
        for(int i = 1;i < len;i ++){
        	if(nums[i] != nums[index]){
        		nums[++index] = nums[i];
        	}
        }
        
        return index + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
