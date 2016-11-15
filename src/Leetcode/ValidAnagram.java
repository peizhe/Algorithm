package Leetcode;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        char[] sChar = s.trim().toCharArray();
		char[] tChar = t.trim().toCharArray();
		int[] countS = new int[26];
		int[] countT = new int[26];
		for(int i = 0;i < sChar.length;i ++){
			countS[sChar[i] - 'a'] ++;
		}
		
		for(int i = 0;i < tChar.length;i ++){
			countT[tChar[i] - 'a'] ++;
		}
		
		for(int i = 0;i < countS.length;i ++){
			if(countS[i] != countT[i]){
				return false;
			}
		}
		
		return true;
    }
}
