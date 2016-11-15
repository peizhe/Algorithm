package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	
	List<List<Integer>> ls = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();
	int size;
	int target;
	public List<List<Integer>> combinationSum3(int k, int n) {
		if(n < 1){
			return ls;
		}
		size = k;
		target = n;
		
        wideSearch(1);
        return ls;
    }
	
	//熟悉这种回溯方法(dfs)
	public void wideSearch(int begin){
		//计算当前的temp中的和
		int sum = 0;
		for(int i = 0;i < temp.size();i ++){
			sum += temp.get(i);
		}
		
		if(temp.size() == size && sum == target){
			ArrayList<Integer> newlist = new ArrayList<Integer>(temp); 
			ls.add(newlist);
		}
		else if(sum > target){
			return;
		}
		else{
			for(int i = begin;i < 10;i ++){
				if(i > target){
					return;
				}
				else{
					if(temp.size() < size){
						temp.add(i);
						wideSearch(i + 1);
						temp.remove(temp.size() - 1);
					}
				}
			}
		}
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII c = new CombinationSumIII();
		c.combinationSum3(2, 9);
		
		for(int i = 0;i < c.ls.size();i ++){
			for(int j = 0;j < c.ls.get(i).size();j ++){
				System.out.print(c.ls.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
