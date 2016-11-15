package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        findSum(candidates,target,0,0,result,temp);
        return result;
    }
	
	//深度优先搜索，掌握这个方法
	public static void findSum(int[] candidates, int target,int sum,
					int level,List<List<Integer>> res,List<Integer> temp){
		if(sum > target){
			return;
		}
		else if(sum == target){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		else{
			for(int i = level;i < candidates.length;i ++){
				temp.add(candidates[i]);
				findSum(candidates, target, candidates[i] + sum, i, res, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	public static void main(String[] mh){
		int[] a = {2,3,6,7};
		int target = 7;
		
		List<List<Integer>> result = combinationSum(a, target);
		for(int i = 0;i < result.size();i ++){
			int size = result.get(i).size();
			for(int j = 0;j < size;j ++){
				System.out.print(result.get(i).get(j) + " ");
			}
			
			System.out.println();
		}
	}
}
