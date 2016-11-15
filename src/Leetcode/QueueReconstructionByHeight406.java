package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * 学习多关键字排序！！！
 * 
 * int compare(Object o1, Object o2) 返回一个基本类型的整型
 * 如果要按照升序排序，
 * 		则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
 * 如果要按照降序排序
 * 		则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
 * 
 * @author MG
 *
 */
public class QueueReconstructionByHeight406 {
	public static int[][] reconstructQueue(int[][] people) {
		//高度相同，则根据比他高的人数就行排序
		//高度不同，则根据高度进行排序
		//相当于多关键字排序，高度是主关键字，比他高的人数是次关键字
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				//这里是按高度降序，按比他高的人数升序
				return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
			}
		});
		
		List<int[]> res = new LinkedList<int[]>();
		
		for(int[] i : people) {
			res.add(i[1], i);
		}
			
		return res.toArray(new int[people.length][]);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		reconstructQueue(people);
	}
}
