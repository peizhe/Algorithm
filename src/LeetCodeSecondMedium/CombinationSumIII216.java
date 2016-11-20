package LeetCodeSecondMedium;

import java.util.*;

/**
 * dfs
 * 
 * @author MG
 * 
 */
public class CombinationSumIII216 {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		dfs(res, new ArrayList<Integer>(), k, n, 1);

		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> temp, int k,
			int n, int current) {
		if (temp.size() == k && n == 0) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = current; i < 10; i++) {
			if(i > n) break;
			
			temp.add(i);
			dfs(res, temp, k, n - i, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinationSum3(2, 3);
	}
}
