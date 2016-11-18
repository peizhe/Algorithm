package LeetCodeSecondEasy;

public class LongestPalindrome409 {
	
	public static int longestPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		int[] map = new int[128];
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			map[s.charAt(i)] ++;
		}
		
		boolean isExistOdd = false;
		int res = 0;
		for(int i = 0; i < 128; i++) {
			if((map[i] & 1) == 1) {
				isExistOdd = true;
				res += map[i] - 1;
			} else {
				res += map[i];
			}
		}
		
		return isExistOdd ? res + 1 : res;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
