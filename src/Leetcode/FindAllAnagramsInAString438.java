package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串匹配 : 
 * 	1.每次后移一个单位进行比对，前一个匹配，则比较移出字符和新加入字符是否相等，相等则也匹配(比较耗时) 2.记录不同字符的个数
 * 	2.只记录不同字符的个数
 * @author MG
 * 
 */
public class FindAllAnagramsInAString438 {

	public static List<Integer> findAnagrams(String s, String p) {
		if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> res = new ArrayList<Integer>();
		int len1 = s.length(), len2 = p.length();
		
		int[] anagram = new int[128];

		for (int i = 0; i < len2; i++) {
			anagram[s.charAt(i)]++;
			anagram[p.charAt(i)]--;
		}
		int diff = 0;
		
		//统计不同字符的个数
		for (int i : anagram) {
			if (i != 0)
				diff++;
		}
		
		for (int i = len2; i < len1; i++) {
			//不同字符数是0
			if (diff == 0)
				res.add(i - len2);
			
			//移出的字符
			char c1 = s.charAt(i);
			//新加入的字符
			char c2 = s.charAt(i - len2);
			if (c1 == c2) {
				//移出的字符和当前新加入的字符相同
				continue;
			}

			anagram[c1]++;
			anagram[c2]--;
			
			if (anagram[c1] == 1)
				diff++;
			else if (anagram[c1] == 0)
				diff--;

			if (anagram[c2] == -1)
				diff++;
			else if (anagram[c2] == 0)
				diff--;
		}
		
		if (diff == 0) {
			res.add(len1 - len2);
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}

}
