package Algorithm;

/**
 * 字符串的正则表达式匹配 ： 
 * 	*代表匹配前面字符1次或多次
 *  .代表匹配一个字符
 * 	精髓 : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * 
 * @author MG
 * 
 */
public class RegularStringMatch {
	public boolean isMatch(String s, String p) {
		if(s == null){
			return false;
		}
		
		int slen = s.length(),plen = p.length();
		boolean[][] dp = new boolean[slen + 1][plen + 1];
		dp[0][0] = true;
		
        // p[0.., j - 3, j - 2, j - 1] matches empty if p[j - 1] is '*' and p[0..j - 3] matches empty
        for (int j = 1; j <= plen; j++)
            dp[0][j] = j > 1 && '*' == p.charAt(j - 1) && dp[0][j - 2];
        
        for (int i = 1; i <= slen; i++)
            for (int j = 1; j <= plen; j++)
                if (p.charAt(j - 1) != '*')
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1));
                else
                    // p[0] cannot be '*' so no need to check "j > 1" here
                	//dp[i][j - 2] 无需检查 s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)，这里不使用dp[i][j - 1]
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && dp[i - 1][j]);
        
		return dp[slen][plen];
	}

}
