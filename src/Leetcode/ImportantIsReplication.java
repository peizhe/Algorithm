package Leetcode;
/**
 * ���⣺һ����СΪn�����飬������������ڷ�Χ[0, n-1]���в�ȷ�����ظ�Ԫ�أ��ҵ�����һ���ظ�Ԫ��
 * ˼·1���������뵽������ϣ������ɣ�����һ������Ϳ��Խ�ÿ��Ԫ��ӳ�䵽��ϣ���С�
 * 		 �����ϣ�����Ѿ��������Ԫ����˵������Ǹ��ظ�Ԫ�ء�
 *      ���ַ������Ժܷ������O(n)ʱ������ɶ��ظ�Ԫ�صĲ��ҡ��ռ临�ӶȱȽϸ�
 * ˼·2�����û��������˼�룬��i�����ڵ�i��λ��
 * @author MG
 *
 */
public class ImportantIsReplication {
	
	public int isReplication(int[] nums){
		int len = nums.length;
		if(len <= 0){
			return -1;
		}
		
		for(int i = 0;i < len;){
            if(nums[i] != i){
                // �����ظ�Ԫ��
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else{
                ++ i;
            }
        }
		
		return -1;
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ImportantIsReplication iir = (ImportantIsReplication)Class.forName("leetcode.ImportantIsReplication").newInstance();
		int[] nums = {2,4,5,1,2,4,3};
		System.out.println(iir.isReplication(nums));
	}
}
