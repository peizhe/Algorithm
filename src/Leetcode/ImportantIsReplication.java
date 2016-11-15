package Leetcode;
/**
 * 题意：一个大小为n的数组，里面的数都属于范围[0, n-1]，有不确定的重复元素，找到至少一个重复元素
 * 思路1：很容易想到建立哈希表来完成，遍历一遍数组就可以将每个元素映射到哈希表中。
 * 		 如果哈希表中已经存在这个元素则说明这就是个重复元素。
 *      这种方法可以很方便的在O(n)时间内完成对重复元素的查找。空间复杂度比较高
 * 思路2：运用基数排序的思想，数i放置在第i个位置
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
                // 存在重复元素
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
