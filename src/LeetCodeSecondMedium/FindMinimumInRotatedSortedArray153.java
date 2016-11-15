package LeetCodeSecondMedium;
/**
 * ��һ������������ת�����Сֵ
 * 	1.���ַ�����nums[begin] < nums[end]ʱ��֤������������ģ���Сֵ��Ϊ������Ԫ��
 * 			��nums[begin] > nums[end]ʱ��֤����ת�ˣ�����Сֵ���Ҳ�
 * @author MG
 *
 */
public class FindMinimumInRotatedSortedArray153 {
	public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        
        return getMin(nums, 0, nums.length - 1);
    }
	
	private static int getMin(int[] nums,int begin,int end){
		if(nums[begin] <= nums[end]){
			return nums[begin];
		}
		
		int mid = begin + (end - begin) / 2;
    	if(nums[mid] < nums[end]){
    		return getMin(nums, begin, mid);
    	}
		
    	return getMin(nums, mid + 1, end);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3,2,1};
		System.out.println(findMin(nums));
	}

}
