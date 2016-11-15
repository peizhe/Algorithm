package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * �ַ���ƥ�� : 
 * 	1.ÿ�κ���һ����λ���бȶԣ�ǰһ��ƥ�䣬��Ƚ��Ƴ��ַ����¼����ַ��Ƿ���ȣ������Ҳƥ��(�ȽϺ�ʱ) 2.��¼��ͬ�ַ��ĸ���
 * 	2.ֻ��¼��ͬ�ַ��ĸ���
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
		
		//ͳ�Ʋ�ͬ�ַ��ĸ���
		for (int i : anagram) {
			if (i != 0)
				diff++;
		}
		
		for (int i = len2; i < len1; i++) {
			//��ͬ�ַ�����0
			if (diff == 0)
				res.add(i - len2);
			
			//�Ƴ����ַ�
			char c1 = s.charAt(i);
			//�¼�����ַ�
			char c2 = s.charAt(i - len2);
			if (c1 == c2) {
				//�Ƴ����ַ��͵�ǰ�¼�����ַ���ͬ
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
