package Algorithm;

/**
 * �ַ�����ģ��ƥ�� �� 
 * 	*����ƥ�������ַ�
 *  ?����ƥ��һ���ַ�
 * 	���� : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * @author MG
 * 
 */
public class BlurryStringMatch {
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
