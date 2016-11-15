package LeetCodeSecondEasy;

public class StringToInteger8 {
	public static int myAtoi(String str) {
		if(str == null || str.trim().length() == 0){
			return 0;
		}
		
		str = str.trim();
		char ch = str.charAt(0);
		int i;
		long res = 0, temp;
		boolean negative = ch == '-' ? true : false;
		if(ch == '+' || ch == '-'){
			i = 1;
		} else{
			i = 0;
		}
		
		for(;i < str.length();i ++){
			ch = str.charAt(i);
			if(!isNumber(ch)){
				break;
			}
			
			res *= 10;
			res += ch - '0';
			
			temp = negative ? -res : res;
			if(temp > Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			} else if(temp < Integer.MIN_VALUE){
				return Integer.MIN_VALUE;
			}
		}
		
        return (int) (negative ? -res : res);
    }
	
	private static boolean isNumber(char x){
		return x >= '0' && x <= '9';
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("2147483648"));
	}

}
