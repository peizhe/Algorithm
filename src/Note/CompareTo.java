package Note;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��ϸ����һ��compare����(��ο�������ͽ���)
 * 		
 * int compare(Object o1, Object o2) ����һ���������͵�����
 * 		return o1 - o2 : ����
 * 		return o2 - o1 : ����
 * 
 * ���Ҫ������������
 * 		��o1 С��o2������-1������������ȷ���0��01����02����1��������
 * ���Ҫ���ս�������
 * 		��o1 С��o2������1������������ȷ���0��01����02����-1��������
 * 
 * @author MG
 *
 */
public class CompareTo {
	public static void main(String[] mh){
		//����Ƿ�����
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
