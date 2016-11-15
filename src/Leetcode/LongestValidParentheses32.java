package Leetcode;

/**
 * 1.动态规划的写法越来越多样了 : 2.用栈实现
 * 
 * @author MG
 * 
 */
public class LongestValidParentheses32 {
	public static int longestValidParenthesesDP(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] ch = s.toCharArray();
		int len = ch.length;
		int[] dp = new int[len];

		int res = 0;
		for (int i = 1; i < len; i++) {
			// i - dp[i - 1] - 1 >= 0 保证ch中访问时不会越界
			if (ch[i] == ')' && i - dp[i - 1] - 1 >= 0
					&& ch[i - dp[i - 1] - 1] == '(') {
				dp[i] = dp[i - 1]
						+ 2
						+ ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);

				res = Math.max(dp[i], res);
			}
		}

		return res;
	}

	/**
	 * 使用栈的方式实现的 : (c++ 可以通过,java超时，不知道什么鬼)
	 * 	1.Scan the string from beginning to end.
	 * 
	 * 	2.If current character is '(', push its index to the stack. 
	 * 	  If current character is ')' and the character at the index of the top of stack is '(', 
	 * 	  we just find a matching pair so pop from the stack. Otherwise, we push the index of ')' to the stack.
	 * 
	 * 	3.After the scan is done, the stack will only contain the indices of characters which cannot be matched. 
	 * 	  Then let's use the opposite side - substring between adjacent indices should be valid parentheses.
	 * 
	 * 	4.If the stack is empty, the whole input string is valid. Otherwise, we can scan the stack to get longest
	 * 	  valid substring as described in step 3.
	 * 
	 */
	public static int longestValidParentheses(String str) {
		char[] s = str.toCharArray();
		int n = s.length, longest = 0;
		int[] stack = new int[n + 1];
		int top = 0;
		for (int i = 0; i < n; i++) {
			if (s[i] == '(')
				stack[top ++] = i;
			else {
				if (top > 0) {
					if (s[stack[top - 1]] == '(')
						top --;
					else
						stack[top ++] = i;
				} else
					stack[top ++] = i;
			}
		}
		
		if (top == 0)
			longest = n;
		
		else {
			int a = n, b = 0;
			while (top > 0) {
				b = stack[-- top];
				
				longest = Math.max(longest, a - b - 1);
				
				a = b;
			}
			
			longest = Math.max(longest, a);
		}
		return longest;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()(())";
		System.out.println(longestValidParentheses(s));
	}

}
