package Leetcode;
/**
 * ��������(Ͱ����)��˼��
 * @author Administrator
 *
 */
public class ImportantFirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;){
        	//�����i��λ�ò�����i + 1����nums[i]��nums[nums[i]]���н�����ֱ��nums[i] <= 0 ����nums[i] == i + 1
        	//������Լ��������nums[i] > 0;nums[i] - 1 ����Խ�磬����ᱨoutofindex;nums[nums[i] - 1] != nums[i] �����������ѭ����
        	if(nums[i] != i + 1 && nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
        		//���ｻ����ʱ��Ҫ�Ƚ�nums[nums[i] - 1]��ֵ����ʱ�������Ƚ�nums[i]��ֵ�ͻ����
        		int temp = nums[nums[i] - 1];
        		nums[nums[i] - 1] = nums[i];
        		nums[i] = temp;
        	}
        	else{
        		i ++;
        	}
        }
        
        //����һ�飬���nums[i] != i + 1,���ҵ���һ��ȱʧ������
        for(int i = 0;i < nums.length;i ++){
        	if(nums[i] != i + 1){
        		return i + 1;
        	}
        }
        
        return nums.length + 1;
    }
}
