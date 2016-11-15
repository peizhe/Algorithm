package LeetCodeSecondEasy;
/**
 * ɾ��������ָ����ĳ��ֵ��������ɾ���������ĳ��ȣ�
 * 	1.ǰ��ָ�루ǰָ��Ѱ�ҵ�һ������Ŀ��ֵ��λ�ã���ָ��Ѱ�ҵ�һ����ΪĿ��ֵ��λ�ã�Ȼ�󽻻���
 * @author MG
 *
 */
public class RemoveElement27 {
	public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int begin = 0,end = nums.length - 1;
        
        while(begin <= end){
        	while(begin <= end && nums[begin] != val){
        		begin ++;
        	}
        	
        	while(begin <= end && nums[end] == val){
        		end --;
        	}
        	
        	if(begin < end){
        		int temp = nums[begin];
            	nums[begin] = nums[end];
            	nums[end] = temp;
            	
            	begin ++;
            	end --;
        	}
        }
        
        return begin;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{3,2,2,3};
		RemoveElement27.removeElement(a, 3);
	}

}
