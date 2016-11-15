package Leetcode;
/**
 * ��Ϊ�����ַ�������������ԳƵģ�����������Ǵ��±� i ��������2��ָ���� i ��������չ�ж��Ƿ���ȣ�
 * ��ôֻ��Ҫ��0��n-1���±궼���˲������Ϳ��������Ļ����Ӵ�������Ҫע����ǣ������ַ�������ż�Գ�֮�֣���"abcba"��"abba"2�����ͣ�
 * �����Ҫ�ڴ����дʱ�����жϡ�
 * �躯��int Palindromic(String s,int i,int j) �������±� i �� j ��������չ�Ļ��Ĵ��ĳ��ȣ�
 * ��ô��0��n-1���±꣬����2�δ˺�����
 * int lenOdd = Palindromic(str,i,i)��
 * int lenEven = Palindromic(str,i,j)��
 * ���������i �±�Ϊ����ĺ�ż���ĵ��Ӵ����ȡ�
 * ��������lenOdd��lenEven�е����ֵ�뵱ǰ���ֵmax�Ƚϼ��ɡ�
 * ���������һ���ô���ʱ�临�Ӷ�ΪO(n2)���Ҳ���Ҫʹ�ö���Ŀռ䡣
 * @author Administrator
 *
 */
public class LongestPalindromicSubstring {
	
	public  static String longestPalindrome(String s) {  
        if (s.isEmpty()) {  
            return null;  
        }  
        if (s.length() == 1) {  
            return s;  
        }  
        String longest = s.substring(0, 1);  
        for (int i = 0; i < s.length(); i++) {  
            // get longest palindrome with center of i  
            String tmp = helper(s, i, i);  
            if (tmp.length() > longest.length()) {  
                longest = tmp;  
            }  
  
            // get longest palindrome with center of i, i+1  
            tmp = helper(s, i, i + 1);  
            if (tmp.length() > longest.length()) {  
                longest = tmp;  
            }  
        }  
        return longest;  
    }  
  
    // Given a center, either one letter or two letter,  
    // Find longest palindrome  
    public static String helper(String s, int begin, int end) {  
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {  
            begin --;  
            end ++;  
        }  
        String subS = s.substring(begin + 1, end);  
        return subS;  
    }
}
