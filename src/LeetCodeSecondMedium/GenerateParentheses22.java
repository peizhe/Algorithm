package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * 搞清楚字符串在递归函数中栈内存和堆内存如何存在
 * 
 * @author MG
 *
 */
public class GenerateParentheses22 {
	
	/**
	 * StringBuider来存储
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
        if(n <= 0) {
        	return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<>();
        helper(n, n, new StringBuilder(), res);
        
        return res;
    }
	
	private void helper(int leftCount, int rightCount, StringBuilder sb, List<String> res) {
		if(leftCount > rightCount) {
			return;
		}
		
		if(leftCount == 0 && rightCount == 0) {
			res.add(new String(sb.toString()));
			return;
		}
		
		if(leftCount > 0) {
			helper(leftCount - 1, rightCount, sb.append('('), res);
			sb.deleteCharAt(sb.length() - 1);
		}
		
		if(rightCount > 0) {
			helper(leftCount, rightCount - 1, sb.append(')'), res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	/**
	 * String 来存储
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesisString(int n) {
		List<String> res = new ArrayList<String>();
		if (n < 1) {
			return res;
		}

		help(res, "", n, n);

		return res;
	}

	private static void help(List<String> res, String s, int left, int right) {
		if (left <= right) {
			if (left == 0 && right == 0) {
				res.add(s);
				return;
			}

			if (left > 0) {
				help(res, s + "(", left - 1, right);
			}
			
			if (right > 0) {
				help(res, s + ")", left, right - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
