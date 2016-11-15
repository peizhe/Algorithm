package Leetcode;

public class CountAndSay38 {
	public static String countAndSay(int n) {
       if(n < 1){
    	   return "";
       } 
       
       String res = "1";
       for(int i = 1;i < n; i++) {
    	   res = generateNext(res);
       }
       
       return res;
    }

	private static String generateNext(String s) {
		if(s.length() == 1){
			return 1 + s;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int count = 1;
		int len = s.length();
		for (int i = 1; i < len; i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				sb.append(count + "" + s.charAt(i - 1));
				count = 1;
			} else {
				count++;
			}
			
			if(i == len - 1){
				sb.append(count + "" + s.charAt(len - 1));
			}
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}
}
