package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexIdentity {
	public static List<String> index(int[] nums,int target){
		int max = nums[0],len = nums.length;
		for(int i = 1;i < len;i ++){
			if(nums[i] > max){
				max = nums[i];
			}
		}
		
		int[] map = new int[max + 1];
		Arrays.fill(map, -1);
		int lenMap = map.length;
		for(int i = 0;i < len;i ++){
			map[nums[i]] = i;
		}
		
		int begin = 0,end = lenMap - 1;
		List<String> res = new ArrayList<String>();
		while(begin < end){
			while(map[begin] == -1 && begin < end){
				begin ++;
			}
			
			while(map[end] == -1 && begin < end){
				end --;
			}
			
			int temp = begin + end;
			if(temp == target){
				res.add((map[begin] + 1) + "," + (map[end] + 1));
				begin ++;
				end --;
			} else if(temp > target){
				end --;
			} else{
				begin ++;
			}
		}
		
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,4,7,9,11,5};
		int target = 9;
		List<String> res = index(nums,target);
		for(String s : res){
			System.out.print(s + " ");
		}
	}

}
