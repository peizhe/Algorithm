package Leetcode;
/**
 * 思想还是蛮厉害的！
 */
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class UglyNumberII {
	
	public int nthUglyNumber(int n) {
		
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(1);
		//其实就是三个下标都是从uglyNum的最小值开始的
		int count2 = 0,count3 = 0,count5 = 0;
		while(ls.size() < n){
			//其实是3个指针(count2，count3，count5分别对应ls的下标)
			int x = ls.get(count2) * 2;
			int y = ls.get(count3) * 3;
			int z = ls.get(count5) * 5;
			
			int temp = Math.min(Math.min(x, y), z);
			ls.add(temp);
			
			//如果最小值是*2得到，则将count2指针后移
			if(temp % 2 == 0){
				count2 ++;
			}
			//如果最小值是*3得到，则将count3指针后移
			if(temp % 3 == 0){
				count3 ++;
			}
			//如果最小值是*5得到，则将count5指针后移
			if(temp % 5 == 0){
				count5 ++;
			}
		}
		
		return ls.get(ls.size() - 1);
    }
	
	public int nthUglyNumber1(int n) {
		//set中不存在重复元素
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
