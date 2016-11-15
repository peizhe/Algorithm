package Leetcode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		int begin = 0,end = s.length() - 1;
		while(begin < end){
			while(begin < end && !isAZ(s.charAt(begin))){
				begin ++;
			}
			while(end > begin && !isAZ(s.charAt(end))){
				end --;
			}
			
			if(!(s.charAt(begin) + "").equalsIgnoreCase(s.charAt(end) + "")){
				return false;
			}
			else{
				begin ++;
				end --;
			}
		}
		
		return true;
    }
	
	public static boolean isAZ(char c){
		if((c >= 'a'&& c <= 'z') ||(c >= 'A' && c <= 'Z') ||(c >= '0' && c <= '9')){
			return true;	
		}
		else{
			return false;
		}
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a.";
		System.out.println(isPalindrome(s));
	}
}
