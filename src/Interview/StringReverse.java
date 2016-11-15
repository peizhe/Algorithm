package Interview;

public class StringReverse {
	public static String reverse(String s){
		if(s == null || s.trim().length() == 0){
			return s;
		}
		
		int begin = 0,len = s.length();
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		while(begin < len){
			if(isChar(ch[begin])){
				sb.append(ch[begin]);
			} else {
				res.append(sb.reverse().toString());
				res.append(ch[begin]);
				sb.delete(0, sb.length());
			}
			
			begin ++;
		}
		
		res.append(sb.reverse().toString());
		return res.toString();
	}
	
	 public static boolean isChar(char chr){
	        if(chr >= 'a' && chr <= 'z') return true;
	        if(chr >= 'A' && chr <= 'Z') return true;
	        return false;
	  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I,have a dream";
		System.out.println(reverse(s));
	}

}
