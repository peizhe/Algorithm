package Algorithm;

import java.util.*;

/**
 * 基数排序
 * @author MG
 *
 */
public class RadixSort {
	public static int[] sort(int[] a){
		//获得最大数的位数
		String temp;
		int maxlen = 0;
		for(int i = 0;i < a.length;i ++){
			temp =  a[i] + "";
			if(temp.length() > maxlen){
				maxlen = temp.length();
			}
		}
		
		List<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i < maxlen;i ++){
			//每一轮后桶清空
			for(int count = 0;count < 10;count ++){
				ArrayList<Integer> ls = new ArrayList<Integer>();
				store.add(ls);
			}
			
			int[] b = getIndex(a, i + 1);
			for(int j = 0;j < store.size();j ++){
				store.get(b[j]).add(a[j]);
			}
			
			int index = 0;
			for(int k = 0;k < store.size();k ++){
				ArrayList<Integer> ls = store.get(k);
				if(ls.size() > 0){
					for(int m = 0;m < ls.size();m ++){
						a[index] = ls.get(m);
						index ++;
					}
				}
			}
			store = new ArrayList<ArrayList<Integer>>();
		}
		return a;
	}
	
	public static int[] getIndex(int[] a,int index){
		int[] b = new int[a.length];
		double temp = Math.pow(10, index - 1);
		
		for(int i = 0;i < a.length;i ++){
			b[i] = (int)(a[i] / temp) % 10;
		}
		return b;
	}
	
	public static void main(String[] mh){
		int[] a = {72,385,521,310,373,15,546,856,187,147};
		a = sort(a);
		for(int i = 0;i < a.length;i ++){
			System.out.print(a[i] + " ");
		}
	}
}
