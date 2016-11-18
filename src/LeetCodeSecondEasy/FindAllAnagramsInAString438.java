package LeetCodeSecondEasy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 方法: 
 * 	1.将p排序,在s中截取p长度子子串分别和p进行比较(超时)
 * 	2.将每个字母用质数表示,则乘积是一个固定值(通过比较乘积判断是否相等)(BigInteger有坑,使用注意执行完加减乘除要重新赋值) stardand = stardand.multiply(new BigInteger(map[x - 'a'] + ""));
 * 	3.用一个数组存储字母的个数以及字母不同的个数(leetcode提交的上面有)	
 * 
 * @author Administrator
 *
 */
public class FindAllAnagramsInAString438 {

	public static List<Integer> findAnagrams(String s, String p) {
		int[] map = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
				43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
		if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
			return new ArrayList<Integer>();
		}

		BigInteger stardand = new BigInteger(1 + "");
		for(char x : p.toCharArray()) {
			stardand = stardand.multiply(new BigInteger(map[x - 'a'] + ""));
		}
		
		List<Integer> res = new ArrayList<Integer>();
		int slen = s.length(), plen = p.length(); 
		BigInteger temp = new BigInteger("1");
		for(int i = 0; i < plen; i++) {
			temp = temp.multiply(new BigInteger(map[s.charAt(i) - 'a'] + ""));
		}
		
		if(temp.equals(stardand)) res.add(0);
		
		for (int i = plen; i < slen; i++) {
			temp = temp.divide(new BigInteger(map[s.charAt(i - plen) - 'a'] + ""));
			temp = temp.multiply(new BigInteger(map[s.charAt(i) - 'a'] + ""));
			
			if(temp.equals(stardand))
				res.add(i - plen + 1);
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "abc";
		String p = "yqrbgjdwtcaxzsnifvhmou";
		
		List<Integer> res =  findAnagrams(s, p);
		for(int i : res) {
			System.out.print(i + " ");
		}
		
	}

}
