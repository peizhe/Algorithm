package LeetCodeSecondEasy;

public class ExcelSheetColumnNumber171 {
	public static int titleToNumber(String s) {
		boolean flag = check(s);
		
		if(flag){
			int res = s.charAt(0) - 'A' + 1;
	        int length = s.length();
	        
	        for(int i = 1;i < length;i ++){
	        	res = res * 26 + (s.charAt(i) - 'A' + 1);
	        }
	        
	        return res;
		}else{
			return -1;
		}
    }
	
	/**
	 * 检查输入是否合法
	 * @param s
	 * @return
	 */
	private static boolean check(String s){
		if(s == null || s.trim().length() == 0){
			return false;
		}
		
		s = s.trim();
		
		for(int i = 0;i < s.length();i ++){
			if(s.charAt(i) < 'A' || s.charAt(i) > 'Z'){
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
		System.out.println(titleToNumber("AAB"));
	}

}
