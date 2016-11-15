package Leetcode;
/**
 * 基数排序(桶排序)的思想
 * @author Administrator
 *
 */
public class ImportantFirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;){
        	//如果第i个位置不等于i + 1，将nums[i]和nums[nums[i]]进行交换，直到nums[i] <= 0 或者nums[i] == i + 1
        	//交换的约束条件（nums[i] > 0;nums[i] - 1 不能越界，否则会报outofindex;nums[nums[i] - 1] != nums[i] 否则进入了死循环）
        	if(nums[i] != i + 1 && nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]){
        		//这里交换的时候要先将nums[nums[i] - 1]赋值给临时变量，先将nums[i]赋值就会出错！
        		int temp = nums[nums[i] - 1];
        		nums[nums[i] - 1] = nums[i];
        		nums[i] = temp;
        	}
        	else{
        		i ++;
        	}
        }
        
        //遍历一遍，如果nums[i] != i + 1,则找到第一个缺失的正数
        for(int i = 0;i < nums.length;i ++){
        	if(nums[i] != i + 1){
        		return i + 1;
        	}
        }
        
        return nums.length + 1;
    }
}
