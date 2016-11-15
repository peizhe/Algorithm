package LeetCodeSecondEasy;

/**
 * 判断字符串s t是否是相同字母的不同排序
 * 	1.使用map实现，字母个数相同即可
 *  2.对两个字符串字母排序，排序完看是否相等
 *  3.自己建立map(一共就256个字符)
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
