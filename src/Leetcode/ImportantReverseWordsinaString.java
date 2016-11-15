package Leetcode;
/**
 * 思想很简单，测试用例简直醉了
 * @author Administrator
 *
 */
public class ImportantReverseWordsinaString {
	
	public String reverseWords(String s) {
		if(s == null ||s.trim() == ""){
			return "";
		}
		String result = "";
		
        String ss = s.trim();
        String temp = "";
        int end = ss.length() - 1;
        
        while(end > 0){
        	if(ss.charAt(end) == ' ' && ss.charAt(end - 1) != ' '){
        		result = result + temp + " ";
        		temp = "";
        	}
        	
        	if(ss.charAt(end) != ' '){
        		temp = ss.charAt(end) + temp;
        	}
        	
        	end --;
        }
        result = result + (ss.length() > 0 ? ss.charAt(0) : "") + temp;
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?> c = Class.forName("leetcode.ReverseWordsinaString");
			ImportantReverseWordsinaString r = (ImportantReverseWordsinaString) c.newInstance();
			
			String s = "hi!";
			System.out.println(r.reverseWords(s));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
