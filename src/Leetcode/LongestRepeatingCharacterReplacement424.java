package Leetcode;

/**
 * 理解题目: 不是将某一类字符替换成其他任意字符，而是可以把任意字符替换成任意字符
 * 
 * @author MG
 * 
 */
public class LongestRepeatingCharacterReplacement424 {
	public static int characterReplacement(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		int[] map = new int[26];
		int maxOccur = 0, begin = 0, res = 1;

		for (int end = 0; end < len; end++) {
			map[s.charAt(end) - 'A']++;
			if (map[s.charAt(end) - 'A'] > maxOccur) {
				maxOccur = map[s.charAt(end) - 'A'];
			}
			
			//证明当前要替换的字母数量大于k，则需要从头开始删，直到要替换的字母数量<=k
			while (end - begin + 1 - maxOccur > k) {
				map[s.charAt(begin) - 'A']--;
				begin ++;
				
				//移出begin后，重新计算maxOccur
				for(int i = 0;i < 26;i ++){
					maxOccur = Math.max(maxOccur, map[i]);
				}
			}
			
			res = Math.max(end - begin + 1, res);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("ABBBA", 2));
	}

}
