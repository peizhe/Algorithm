package Leetcode;
/**
 * 因为回文字符串是以中心轴对称的，所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等，
 * 那么只需要对0到n-1的下标都做此操作，就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，即"abcba"与"abba"2种类型，
 * 因此需要在代码编写时都做判断。
 * 设函数int Palindromic(String s,int i,int j) 是求由下标 i 和 j 向两边扩展的回文串的长度，
 * 那么对0至n-1的下标，调用2次此函数：
 * int lenOdd = Palindromic(str,i,i)和
 * int lenEven = Palindromic(str,i,j)，
 * 即可求得以i 下标为奇回文和偶回文的子串长度。
 * 接下来以lenOdd和lenEven中的最大值与当前最大值max比较即可。
 * 这个方法有一个好处是时间复杂度为O(n2)，且不需要使用额外的空间。
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
