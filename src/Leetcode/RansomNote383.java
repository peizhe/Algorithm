package Leetcode;

public class RansomNote383 {
	public static boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote == magazine || ransomNote.equals(magazine)){
			return true;
		}
        
        if(ransomNote.length() > magazine.length()){
        	return false;
        }
        
        int[] map = new int[26];
        int len1 = ransomNote.length(),len2 = magazine.length();
        int i = 0;
        while(i < len2){
        	int index2 = magazine.charAt(i) - 'a';
        	
        	if(i < len1){
        		int index1 = ransomNote.charAt(i) - 'a';
        		map[index1] --;
        	}
        	
        	map[index2] ++;
        	i ++;
        }
       
        
        for(int n : map){
        	if(n < 0){
        		return false;
        	}
        }
        
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct(null,null));
	}

}
