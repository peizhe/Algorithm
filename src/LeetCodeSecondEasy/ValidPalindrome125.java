package LeetCodeSecondEasy;
/**
 * 以后尽量少用系统自带的函数：系统函数也会耗费时间
 * @author MG
 *
 */
public class ValidPalindrome125 {
	public static boolean isPalindrome(String s) {
        if(s == null || s.trim().length() == 0){
        	return true;
        }
        
        int len = s.length();
        int begin = 0,end = len - 1;
        
        while(begin < end){
        	while(begin < end && !isValid(s.charAt(begin))){
        		begin ++;
        	}
        	
        	while(begin < end && !isValid(s.charAt(end))){
        		end --;
        	}
        	
        	if(!isSame(s.charAt(begin), s.charAt(end))){
        		return false;
        	}
        	
        	begin ++;
        	end --;
        }
        
        return true;
    }

	private static boolean isValid(char c){
	    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z') || (c >= '0' && c <= '9')){
	        return true;
	    }
	    return false;
	}

	private static boolean isSame(char c1, char c2){
	    if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')){
	        return c1 == c2;
	    } else {
	        return c1 == c2 || Math.abs(c1 - c2) == 'a' - 'A';
	    }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0,";
		System.out.println(isPalindrome(s));
	}
}
