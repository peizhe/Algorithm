package Algorithm;
/**
 * 寻找字符串s中最长的有效括号匹配的长度
 * 	1.动态规划的这种思想要记住,理清楚到底这个动态规划怎么写！！！！！！
 * 	
 *  思想！！！！！！！！！！！
 * @author MG
 *
 */
public class ParenthesesMatch {
	public static int parenthesesMatch(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		char[] ch = s.toCharArray();
		int len = ch.length;
		int[] dp = new int[len];

		int res = 0;
		for (int i = 1; i < len; i++) {
			//i - dp[i - 1] - 1 >= 0 保证ch中访问时不会越界
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
