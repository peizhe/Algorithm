package LeetCodeSecondEasy;
/**
 * 删除数组中指定的某个值，并返回删除后的数组的长度：
 * 	1.前后指针（前指针寻找第一个等于目标值的位置，后指针寻找第一个不为目标值的位置，然后交换）
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
