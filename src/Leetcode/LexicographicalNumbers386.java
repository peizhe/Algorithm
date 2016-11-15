package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * LeetCode 的编译器声明静态变量对结果有影响
 * 
 * @author MG
 *
 */
public class LexicographicalNumbers386 {
	
	/**
	 * 写的没问题，编译器有问题
	 */
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i = 1;i < 10;i ++){
			dfs(i, n, res);
		}
        
        return res;
    }
	
	private static void dfs(int current, int max, List<Integer> res){
		if(current > max){
			return;
		}
		
		res.add(current);
		
		for(int i = 0;i < 10;i ++){
			//省去了一部分循环
			if(current * 10 + i > max) return;
			
			dfs(current * 10 + i, max, res);
		}
	}
	
	/**
	 * 超时 : 很简单的方法
	 * @param n
	 * @return
	 */
	public static List<Integer> lexicalOrderTLE(int n) {
        List<String> sort = new ArrayList<String>();
        for(int i = 1;i <= n;i ++){
        	sort.add(i + "");
        }
        
        Collections.sort(sort, new Comparator<String>() {

			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
        
        List<Integer> res = new ArrayList<Integer>();
        for(String i : sort){
        	res.add(Integer.valueOf(i));
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = lexicalOrder(13);
		for(int i : res){
			System.out.print(i + " ");
		}
	}

}
