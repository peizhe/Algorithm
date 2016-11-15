package Leetcode;
/**
 * 深度优先搜索
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	List<List<Integer>> ls = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0){
			return null;
		}        
        if(target <= 0){
			return ls; 
		}
        Arrays.sort(candidates);
        
        wideSearch(candidates,target,0);
        
        return ls;
    }
	
	//熟悉这种回溯方法(dfs)
	public void wideSearch(int[] candidates,int target,int begin){
		//计算当前的temp中的和
		int sum = 0;
		for(int i = 0;i < temp.size();i ++){
			sum += temp.get(i);
		}
		
		if(sum == target){
			ArrayList<Integer> newlist = new ArrayList<Integer>(temp); 
			ls.add(newlist);
		}
		else if(sum > target){
			return;
		}
		else{
			for(int i = begin;i < candidates.length;i ++){
				//这个if判断去除了很多不必要的循环
				if(candidates[i] > target){
					return;
				}
				else{
					temp.add(candidates[i]);
					wideSearch(candidates, target,i + 1);
					temp.remove(temp.size() - 1);
					//跳过重复的元素(自习捋一捋这里，挺迷惑人的)
					while(i < (candidates.length - 1) && candidates[i] == candidates[i + 1]){
						i ++;
					}
				}
			}
		}
	} 
}
