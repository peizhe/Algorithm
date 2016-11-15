package Leetcode;
/**
 * 找到字符串中不满足出现次数 <k 的字符，把该字符作为切割点，返回左右两个子问题的最大长度
 * 
 * @author MG
 *
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		char[] a = s.toCharArray();
		return helper(a, 0, s.length(), k);
	}

	public int helper(char[] a, int start, int end, int k) {
		if (start > end || k > end - start)
			return 0;
		
		//记录字符串start--end子串中各个字符的个数
		int[] count = new int[26];
		for (int i = start; i < end; i++)
			count[a[i] - 'a']++;
		
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0)
				continue;
			
			//如果count[i] < k,则 (i + 'a')字符在字符串中一定不会k次，
			//将i + 'a' 作为切割点，将字符串进行切割，返回左右两边的最大值 
			if (count[i] < k) {
				for (int j = start; j < end; j++) {
					if (a[j] == i + 'a') {
						return Math.max(helper(a, start, j, k),
								helper(a, j + 1, end, k));
					}
				}
			}
		}
		
		return end - start;
	}
}
