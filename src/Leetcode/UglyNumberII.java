package Leetcode;
/**
 * ˼�뻹���������ģ�
 */
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class UglyNumberII {
	
	public int nthUglyNumber(int n) {
		
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		//��ʵ���������±궼�Ǵ�uglyNum����Сֵ��ʼ��
		int count2 = 0,count3 = 0,count5 = 0;
		while(ls.size() < n){
			//��ʵ��3��ָ��(count2��count3��count5�ֱ��Ӧls���±�)
			int x = ls.get(count2) * 2;
			int y = ls.get(count3) * 3;
			int z = ls.get(count5) * 5;
			
			int temp = Math.min(Math.min(x, y), z);
			ls.add(temp);
			
			//�����Сֵ��*2�õ�����count2ָ�����
			if(temp % 2 == 0){
				count2 ++;
			}
			//�����Сֵ��*3�õ�����count3ָ�����
			if(temp % 3 == 0){
				count3 ++;
			}
			//�����Сֵ��*5�õ�����count5ָ�����
			if(temp % 5 == 0){
				count5 ++;
			}
		}
		
		return ls.get(ls.size() - 1);
    }
	
	public int nthUglyNumber1(int n) {
		//set�в������ظ�Ԫ��
		SortedSet<Long> ss = new TreeSet<Long>();
		ss.add((long)1);
		long res = -1;
		for(int i = 0;i < n;i ++){
			res = ss.first();
			
			ss.add(res * 2);
			ss.add(res * 3);
			ss.add(res * 5);
			
			ss.remove(res);
		}
		
		return (int)res;
	}
}
