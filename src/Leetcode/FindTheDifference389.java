package Leetcode;

public class FindTheDifference389 {
	public char findTheDifference(String s, String t) {
		if(s == null || s.length() == 0){
        	return t.charAt(0);
        }
		
        char c = 0;
        int i = 0;
        
        while(i < s.length()){
        	c ^= s.charAt(i) ^ t.charAt(i);
        	i ++;
        }
        
        return (char) (c ^ t.charAt(i));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
