package Leetcode;

/**
 * ͳ��ÿ���ַ����ֵĴ����� �������ڴ��������ż����ӣ������������������ + 1
 * 
 * @author MG
 * 
 */
public class LongestPalindrome409 {
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] counts = new int['z' - 'A' + 1];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			counts[s.charAt(i) - 'A']++;
		}

		int res = 0;
		boolean containOdd = false;
		for (int i : counts) {
			if ((i & 1) == 1) {
				res += i - 1;
				containOdd = true;
			} else {
				res += i;
			}
		}

		return containOdd ? res + 1 : res;
	}
}
