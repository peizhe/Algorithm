package Leetcode;
/**
 * ̰���㷨�����벻��������̫��
 * ̰��,ֻ��Ҫʱ�̼���ǰλ�ú͵�ǰλ������������Զ����,��ʼ�պ�n���ȽϾͿ���:
 * 1,��������posλ�ó���maxstepΪ0�����,��˵���޷�������ǰ�ƶ�,����false
 * 2.��������posλ�ó���maxstep+pos>=n˵������������һ��,����true
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
        	//ÿ�����жϿ�ǰ�����������Ϊ0�������ƶ�
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
