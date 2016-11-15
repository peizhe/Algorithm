package Algorithm;
/**
 * Ѱ��ƥ������ŵķ���(LeetCode-decodeString)
 * 
 * @author MG
 *
 */
public class FindBracketPair {
	
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
				
				//�������ص�Ѱ��ƥ�����ŵķ���
				int right = str.indexOf(']', i + 1);
				int left = str.indexOf('[', i + 1);
				//�ҵ���'['ƥ���']'
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

	}

}
