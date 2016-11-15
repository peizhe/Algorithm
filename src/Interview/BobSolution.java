package Interview;

import java.util.*;
/**
 * 百度面试题
 * @author MG
 *
 */
public class BobSolution {
	public static List<Integer> findBom(int[] nums,int key){
		if(nums == null || nums.length == 0 || key == 0){
			return new ArrayList<Integer>();
		}
		List<Integer> list = new ArrayList<Integer>();
		int len = nums.length;
		int[] sum = new int[len];
		int temp = 0;
		
		if(key < 0){
			int i = 0,j = len - 1;
			while(i < j){
				if(nums[i] != nums[j]){
					nums[i] = nums[i] ^ nums[j];
					nums[j] = nums[i] ^ nums[j];
					nums[i] = nums[i] ^ nums[j];
				}
				
				i ++;
				j --;
			}
		}
		
		int keyAbs = Math.abs(key);
		for(int i = 1;i <= keyAbs;i ++){
			temp += nums[i];
		}
		
		sum[0] = temp;
		for(int i = 1;i < len;i ++){
			sum[i] = temp - nums[i % len] + nums[(i + keyAbs) % len];
			temp -= (nums[i % len] - nums[(i + keyAbs) % len]);
		}
		
		if(key < 0){
			for(int i = len - 1;i >= 0;i --){
				list.add(sum[i]);
			}
			return list;
		}
		
		for(int i : sum){
			list.add(i);
		}
		
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2,3,4,5};
		findBom(a,-3);
	}

}
