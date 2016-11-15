package Leetcode;

public class ExcelSheetColumnNumber {
	
	public static int titleToNumber(String s) {
		if(s.equals("")){
			return 0;
		}
		char[] schar = s.toCharArray();
		int result = schar[0] - 'A' + 1;
		for(int i = 1;i < schar.length;i ++){
			result = result * 26 + schar[i] - 'A' + 1;
		}
		
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "BA";
		System.out.println(titleToNumber(s));
	}

}
