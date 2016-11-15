package LeetCodeSecondEasy;

public class MoveZeroes283 {
	public void moveZeroes(int[] nums) {
        if(nums == null){
        	return;
        }
        
        int index = 0;
        int length = nums.length;
        for(int i = 0;i < length;i ++){
        	if(nums[i] != 0){
        		nums[index ++] = nums[i];
        	}
        }
        
        for(int i = index;i < length;i ++){
        	nums[i] = 0;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
