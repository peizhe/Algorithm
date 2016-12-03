package LeetCodeSecondMedium;

public class LongestSubstringWithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		if(s == null || s.length() == 0 || s.length() < k) return 0;
			
		return helper(s.toCharArray(), 0, s.length() - 1, k); 
	}
	
	private int helper(char[] ch, int begin, int end, int k) {
		if(begin > end || (end - begin + 1) < k) return 0;
		
		int[] map = new int[26];
		for(int i = begin; i <= end; i++) map[ch[i] - 'a']++;
		
		//将字符串按出现不足k次的字母进行切分
		for(int i = begin; i <= end; i++) {
			if(map[ch[i] - 'a'] < k) {
				return Math.max(helper(ch, begin, i - 1, k), helper(ch, i + 1, end, k));
			}
		}
		
		return end - begin + 1;
	}
}
