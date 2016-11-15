package Algorithm;
/**
 * Ѱ���ַ���s�������Ч����ƥ��ĳ���
 * 	1.��̬�滮������˼��Ҫ��ס,��������������̬�滮��ôд������������
 * 	
 *  ˼�룡��������������������
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
			//i - dp[i - 1] - 1 >= 0 ��֤ch�з���ʱ����Խ��
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
