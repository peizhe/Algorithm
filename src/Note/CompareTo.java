package Note;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 仔细梳理一下compare方法(如何控制升序和降序)
 * 		
 * int compare(Object o1, Object o2) 返回一个基本类型的整型
 * 		return o1 - o2 : 升序
 * 		return o2 - o1 : 降序
 * 
 * 如果要按照升序排序，
 * 		则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
 * 如果要按照降序排序
 * 		则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
 * 
 * @author MG
 *
 */
public class CompareTo {
	public static void main(String[] mh){
		//标记是否升序
		final boolean up = true;
		Integer[] nums = new Integer[]{4,5,2,3,6,7,10};
		Arrays.sort(nums, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return up ? o1 - o2 : o2 - o1;
			}
		});
		
		for(Integer i : nums){
			System.out.print(i + " ");
		}
	}
}
