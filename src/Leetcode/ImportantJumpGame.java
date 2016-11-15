package Leetcode;
/**
 * 贪心算法总是想不到，做的太少
 * 贪心,只需要时刻计算前位置和当前位置所能跳的最远长度,并始终和n作比较就可以:
 * 1,若在任意pos位置出现maxstep为0的情况,则说明无法继续向前移动,返回false
 * 2.若在任意pos位置出现maxstep+pos>=n说明可以完成最后一跳,返回true
 * @author MG
 *
 */
public class ImportantJumpGame {
	public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
        	return true;
        }
        
        int maxStep = nums[0];
        for(int i = 1;i < nums.length;i ++){
        	//每次先判断可前进的最大步数，为0，则不能移动
        	if(maxStep == 0){
        		return false;
        	}
        	
        	maxStep --;
        	
        	if(nums[i] > maxStep){
        		maxStep = nums[i];
        	}
        	
        	if(maxStep + i >= nums.length - 1){
        		return true;
        	}
        }
        
        return true;
    }
}
