package Leetcode;

public class FindTheDuplicateNumber {
	//二分查找方法
	public static int findDuplicate(int[] nums) {
		int min = 0,max = nums.length - 1;
		while(min < max){
			int count = 0;
			int mid = min + (max - min) / 2;
			for(int i = 0;i < nums.length;i ++){
				if(nums[i] <= mid){
					count ++;
				}
			}
			if(count <= mid){
				min = mid + 1;
			}
			else{
				max = mid - 1;
			}
		}
		return min;
    }

	public static void main(String[] args) {
		int[] a = {1,1,2,3,4};
		System.out.println(findDuplicate(a));
	}
}
