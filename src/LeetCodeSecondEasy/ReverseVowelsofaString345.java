package LeetCodeSecondEasy;
/**
 * 反转字符串中的元音字母：
 * @author MG
 *
 */
public class ReverseVowelsofaString345 {
	public String reverseVowels(String s) {
        if(s == null || s.trim().length() == 0){
        	return s;
        }
        char[] ch = s.toCharArray();
        int begin = 0;
        int end = ch.length - 1;
        while(begin < end){
        	while(begin < end && !isVowel(ch[begin])){
        		begin ++;
        	}
        	
        	while(begin < end && !isVowel(ch[end])){
        		end --;
        	}
        	
        	char temp = ch[begin];
        	ch[begin] = ch[end];
        	ch[end] = temp;
        	
        	begin ++;
        	end --;
        }
        
		return new String(ch);
    }
	
	private boolean isVowel(char ch){
		switch(ch){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
