package Leetcode;

public class FirstUniqueCharacterString387 {
	public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
        	return -1;
        }
        char[] arr = s.toCharArray();
        char[] map = new char[26];
        for(char ch : arr) map[ch - 'a'] += 1;
        
        for(int i = 0; i < arr.length; i++) {
            if(map[arr[i] -'a'] == 1) 
            	return i; 
        }
        
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
