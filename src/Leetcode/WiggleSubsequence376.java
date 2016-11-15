package Leetcode;
/**
 * 摆动序列:
 * 	动态规划
 * @author MG
 *
 */
public class WiggleSubsequence376 {
	public static int wiggleMaxLength(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int begin = 0;
		int[] count = new int[len];
		count[0] = 1;
		
		boolean needIncrease = true;
		for(int i = 1;i < len;i ++){
			if(nums[i] != nums[i - 1]){
				begin = i;
				needIncrease = nums[i] > nums[i - 1] ? true : false;
				break;
			}
			
			count[i] = count[i - 1];
		}
		//如果数组中元素全部相同
		if(count[len - 1] == 1){
			return count[len - 1];
		}
		
		
		for(int i = begin;i < len;i ++){
			if(nums[i] == nums[i - 1]){
				count[i] = count[i - 1];
				continue;
			}
			
			if(needIncrease){
				if(nums[i] > nums[i - 1]){
					count[i] = count[i - 1] + 1;
					needIncrease = !needIncrease;
				} else {
					count[i] = count[i - 1];
				}
			} else {
				if(nums[i] < nums[i - 1]){
					count[i] = count[i - 1] + 1;
					needIncrease = !needIncrease;
				} else {
					count[i] = count[i - 1];
				}
			}
		}
		
        return count[len - 1];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0,0};
		System.out.println(wiggleMaxLength(nums));
	}
}
