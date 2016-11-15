package LeetCodeSecondEasy;

public class LengthOfLastWord58 {
	public int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0){
        	return 0;
        }
        s = s.trim();
        int len = s.length();
        
        int i;
        for(i = len - 2;i >= 0;i --){
        	if(s.charAt(i) == ' '){
        		break;
        	}
        }
        
        return len - i - 1;
    }
}
