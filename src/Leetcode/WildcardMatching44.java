package Leetcode;

/**
 * ʱ�临�Ӷ���O(n),�ռ临�Ӷ���O(1) The basic idea is to have one pointer for the string
 * and one pointer for the pattern. This algorithm iterates at most
 * length(string) + length(pattern) times, for each iteration, at least one
 * pointer advance one step.
 * 
 * @author MG
 * 
 */
public class WildcardMatching44 {
	/**
	 * ����pattern�вŴ���'?' �� '*';str �в������������ַ�
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public boolean isMatchBetter(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length()
					&& (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
				s ++;
				p ++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p ++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match ++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not
			// *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p ++;

		return p == pattern.length();
	}

	/**
	 * ʹ�ö�̬�滮���
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		//dp[i][j] ���� whether s[0....i-1] matches p[0.....j-1]
		boolean[][] dp = new boolean[m + 1][n + 1];
		//sΪ���ַ�����pҲΪ���ַ���������dp[0][0] = true
		dp[0][0] = true;
		//��ʼ����һ�У���Ϊ��ʱpΪ�գ�ƥ��ȫΪfalse
		for (int i = 1; i <= m; i++) {
			dp[i][0] = false;
		}
		
		//��ʼ����һ�У���p��ǰ׺�е�'*'��Ӧ��λ��ȫ����Ϊtrue(��ʱsΪ���ַ���������'*'ƥ�������ַ����������ַ���)
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//��ǰp�е��ַ�����'*'
				if (p.charAt(j - 1) != '*') {
					//dp[i][j] ���Ϊ dp[i - 1][j - 1] & (��ǰ�������ַ���ͬ || p�ĵ�ǰ�ַ��� '?')
					dp[i][j] = dp[i - 1][j - 1]
							&& (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
					
				} 
				//��ǰp�е��ַ���'*'
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
					
					// ���dp[i - 1][j] �� dp[i][j - 1] ��Ϊfalse,��ǰ��һ����ƥ���ˣ����ʱdp[i][j]һ��Ϊfalse��
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}
		
		return dp[m][n];
	}
}
