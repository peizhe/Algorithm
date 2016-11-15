package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * ѧϰ��ؼ������򣡣���
 * 
 * int compare(Object o1, Object o2) ����һ���������͵�����
 * ���Ҫ������������
 * 		��o1 С��o2������-1������������ȷ���0��01����02����1��������
 * ���Ҫ���ս�������
 * 		��o1 С��o2������1������������ȷ���0��01����02����-1��������
 * 
 * @author MG
 *
 */
public class QueueReconstructionByHeight406 {
	public static int[][] reconstructQueue(int[][] people) {
		//�߶���ͬ������ݱ����ߵ�������������
		//�߶Ȳ�ͬ������ݸ߶Ƚ�������
		//�൱�ڶ�ؼ������򣬸߶������ؼ��֣������ߵ������Ǵιؼ���
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				//�����ǰ��߶Ƚ��򣬰������ߵ���������
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
