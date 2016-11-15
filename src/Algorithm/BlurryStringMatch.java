package Algorithm;

/**
 * 字符串的模糊匹配 ： 
 * 	*代表匹配任意字符
 *  ?代表匹配一个字符
 * 	精髓 : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * @author MG
 * 
 */
public class BlurryStringMatch {
	public static boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		//dp[i][j] 代表 whether s[0....i-1] matches p[0.....j-1]
		boolean[][] dp = new boolean[m + 1][n + 1];
		//s为空字符串，p也为空字符串，所以dp[0][0] = true
		dp[0][0] = true;
		//初始化第一列，因为此时p为空，匹配全为false
		for (int i = 1; i <= m; i++) {
			dp[i][0] = false;
		}
		
		//初始化第一行，将p中前缀中的'*'对应的位置全设置为true(此时s为空字符串，但是'*'匹配任意字符，包括空字符串)
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//当前p中的字符不是'*'
				if (p.charAt(j - 1) != '*') {
					//dp[i][j] 结果为 dp[i - 1][j - 1] & (当前的两个字符相同 || p的当前字符是 '?')
					dp[i][j] = dp[i - 1][j - 1]
							&& (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
					
				} 
				//当前p中的字符是'*'
				else {
					//This idea is:
					//	if(dp[i - 1][j] == true) --> s(0-->i-2) 
					//		matches with p(0-->j-1) now you see p[j - 1] == '*' , 
					//      in the end of s, you can add another or more k chars due to the last of pattern is '*', 
					//		making dp[i][j] or even dp[i + k][j] true;

					//  if(dp[i][j - 1] == true) --> s(0-->i-1) 
					//    	matches with p(0-->j - 2) now you see p[j - 1] == '*', 
					//		add this into p, * can match none in s. you don't need to add anything into s, 
					//		you can see now dp[i][j] = true.
					
					// 如果dp[i - 1][j] 和 dp[i][j - 1] 都为false,则前面一定不匹配了，则此时dp[i][j]一定为false了
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		
		return dp[m][n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbc";
		String p = "a*c";
		System.out.println(isMatch(s, p));
	}

}
