package Leetcode;

/**
 * 判断字符串s是否是字符串t的子序列(s的字符在t中不一定相邻，只要相对位置不变就行)
 * 下面这个方法真的屌，好还斟酌一下
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
