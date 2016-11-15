package LeetCodeSecondEasy;

/**
 * �ж��ַ���s t�Ƿ�����ͬ��ĸ�Ĳ�ͬ����
 * 	1.ʹ��mapʵ�֣���ĸ������ͬ����
 *  2.�������ַ�����ĸ���������꿴�Ƿ����
 *  3.�Լ�����map(һ����256���ַ�)
 * @author MG
 *
 */
public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null){
			return true;
		}
		if(s == null || t == null || s.length() != t.length()){
			return false;
		}
		
		int[] temp = new int[256];
		
		for(int i = 0;i < s.length();i ++){
			temp[s.charAt(i)] += 1; 
		}
		
		for(int i = 0;i < t.length();i ++){
			char indexChar = t.charAt(i);
			temp[indexChar] -= 1;
			if(temp[indexChar] < 0){
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

	}
}
