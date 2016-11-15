package Leetcode;

/**
 * �ж��ַ���s�Ƿ����ַ���t��������(s���ַ���t�в�һ�����ڣ�ֻҪ���λ�ò������)
 * �������������Čţ��û�����һ��
 * @author MG
 *
 */
public class IsSubsequence392 {
	
	public static boolean isSubsequence(String s, String t) {
		if(s.length() > t.length()){
			return false;
		}
		
		char[] array = s.toCharArray();
		int prev = -1;
		
		for(char ch : array){
			prev = t.indexOf(ch, prev + 1);
			if(prev < 0) return false;
		}
		
		return true;
    }
	
	public static void main(String[] mh){
		String t = "leetcetcode";
		
		String s = "leetfcode";
		
		System.out.println(isSubsequence(s,t));
	}
}
