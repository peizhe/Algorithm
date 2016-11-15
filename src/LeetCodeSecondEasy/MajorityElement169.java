package LeetCodeSecondEasy;
/**
 * �ҳ�������Ԫ�س��ִ�������һ�����
 * 	1.�����м��Ǹ�����Ϊ����
 *  2.ͳ��Ԫ����Ŀ����Ŀ����һ���߼�Ϊ����
 *  3.ͶƱѡ�ٷ���(Ч�����)
 * @author MG
 *
 */
public class MajorityElement169 {
	public static int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
        int current = nums[0];
        int count = 1;
        
        for(int i = 1;i < nums.length;i ++){
        	if(count == 0){
        		current = nums[i];
        		count = 1;
        		continue;
        	}
        	
    		if(nums[i] == current){
        		count ++;
        	}else{
        		count --;
        	}
        }
        
        return current;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{2,2,1,1,1,2,2};
		System.out.println(majorityElement(a));
	}
}
