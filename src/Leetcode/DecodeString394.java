package Leetcode;

/**
 * dfs
 * 
 * ½âÂë×Ö·û´®
 * 	s = "3[a]2[bc]", return "aaabcbc".
 * 	s = "3[a2[c]]", return "accaccacc".
 * 	s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author MG
 *
 */
public class DecodeString394 {
	public static String decodeString(String s) {
		if(s == null || s.length() == 0){
			return "";
		}
		
		return decodeDFS(s);
    }
	
	private static String decodeDFS(String str){
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int len = str.length();
		for(int i = 0;i < len;i ++) {
			
			if(isNumber(str.charAt(i))){
				count *= 10;
				count += str.charAt(i) - '0';
			} else if(str.charAt(i) == '['){
				int right = str.indexOf(']', i + 1);
				int left = str.indexOf('[', i + 1);
				//ÕÒµ½Óë'['Æ¥ÅäµÄ']'
				while(left != -1 && right > left){
					right = str.indexOf(']', right + 1);
					left = str.indexOf('[', left + 1);
				}
				
				for(int j = 0;j < count;j ++){
					sb.append(decodeDFS(str.substring(i + 1, right)));
				}
				
				i = right;
				count = 0;
			} else {
				sb.append(str.charAt(i));
				count = 0;
			}
		}
		
		return sb.toString();
	}
	
	private static boolean isNumber(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2[2[2[b]]]";
		System.out.println(decodeString(s));
	}

}
