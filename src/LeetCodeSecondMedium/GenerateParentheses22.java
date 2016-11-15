package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if(n < 1){
			return res;
		}
		
		help(res, "", n, n);
		
		return res;
	}
	
	private static void help(List<String> res,String s,int left,int right){
		if(left <= right){
			if(left == 0 && right == 0){
				res.add(s);
				return;
			}
			
			if(left > 0){
				help(res, s + "(", left - 1, right);
			}
			if(right > 0){
				help(res, s + ")", left, right - 1);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(4);
	}

}
