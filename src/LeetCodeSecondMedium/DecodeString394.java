package LeetCodeSecondMedium;

public class DecodeString394 {
	
	public static String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        
        return helper(s, 0, s.length());
    }
	
	private static String helper(String s, int begin, int end) {
		if(begin >= end) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		int temp = -1;
		for(int i = begin; i < end; i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				sb.append(ch);
			} else if(ch >= '0' && ch <= '9') {
				if(temp == -1) temp = 0;
				temp *= 10;
				temp += ch - '0';
			} else if(ch == '[') {
				int left = s.indexOf('[', i + 1);
				int right = s.indexOf(']', i + 1);
				
				while(left != -1 && left < right) {
					left = s.indexOf('[', left + 1);
					right = s.indexOf(']', right + 1);
				}
				
				String tempRes = helper(s, i + 1, right);
				
				for(int k = 0; k < temp; k++) {
					sb.append(tempRes);
				}
				
				temp = -1;
				i = right;
			}
		}
		
		return sb.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "3[a]2[bc]";
		System.out.println(decodeString(s));
	}

}
