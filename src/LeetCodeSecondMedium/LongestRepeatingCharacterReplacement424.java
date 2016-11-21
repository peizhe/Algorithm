package LeetCodeSecondMedium;


public class LongestRepeatingCharacterReplacement424 {
	public static int characterReplacement(String s, int k) {
		if(s == null || s.length() == 0 || k < 0) {
			return 0;
		}
		int[] map = new int[26];
		int len = s.length();
		
		int maxOccur = 0, begin = 0, res = 0;
		for(int i = 0; i < len; i++) {
			int index = s.charAt(i) - 'A';
			map[index]++;
			maxOccur = map[index] > maxOccur ? map[index] : maxOccur;
			
			if(i - begin + 1 - maxOccur > k) {
				map[s.charAt(begin ++) - 'A'] --;
			}
			
			res = Math.max(i - begin + 1, res);
			
			for(int j = 0; j < 26; j++) {
				maxOccur = map[j] > maxOccur ? map[j] : maxOccur;
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
