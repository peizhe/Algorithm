package Leetcode;

import java.util.ArrayList;
import java.util.List;
//这个深度搜索算法用的有点巧，想不到
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		if (n <= 0)
			return null;
		ArrayList<String> list = new ArrayList<String>();
		
		String str = new String();
		
		dfs(list, str, n, n);
		
		return list;
	}
	//深度搜索算法
	private void dfs(ArrayList<String> list, String str, int left, int right) {
		//left和right分别表示剩余的左括号数量和右括号数量
		if (left > right)
			return;// problem with ")("
		
		if (left == 0 && right == 0) {
			list.add(str);
		}
		
		if (left > 0)
			dfs(list, str + "(", left - 1, right);
		
		if (right > 0)
			dfs(list, str + ")", left, right - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
