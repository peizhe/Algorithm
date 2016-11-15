package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决方法 : 1.dfs(我的实现，比较麻烦) 2.巧方法
 * 
 * @author MG
 * 
 */
public class ReconstructOriginalDigitsFromEnglish423 {
	
	static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static char[] uniqueCharacter = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};
	
	/**
	 * 特点观察
	 * 
	 * The idea is: 
	 * 	for zero, it's the only word has letter 'z', 
	 * 	for two, it's the only word has letter 'w', 
	 * 	...... 
	 *  so we only need to count the unique
	 *  letter of each word, Coz the input is always valid.
	 * 
	 */
	public String originalDigitsBetter(String s) {
		int[] count = new int[10];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch(c){
				case 'z' : count[0] ++;break;
				case 'w' : count[2] ++;break;
				case 'u' : count[4] ++;break;
				case 'x' : count[6] ++;break;
				case 'g' : count[8] ++;break;
				
				case 'o' : count[1] ++;break;// 1-0-2-4
				case 'h' : count[3] ++;break;// 3-8
				case 'f' : count[5] ++;break;// 5-4
				case 's' : count[7] ++;break;// 7-6
				case 'i' : count[9] ++;break;// 9-8-5-6
			}
		}
		count[1] = count[1] - count[0] - count[2] - count[4];
		count[3] -= count[8];
		count[5] -= count[4];
		count[7] -= count[6];
		count[9] = count[9] - count[5] - count[6] - count[8];
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	
	
	static String[] map = new String[] { "zero", "one", "two", "three", "four",
			"five", "six", "severn", "eight", "nine" };
	static int[] count = new int[26];
	static StringBuilder sb = new StringBuilder();
	static List<String> res = new ArrayList<String>();

	public static String originalDigits(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int len = s.length();
		for (int i = 0; i < len; i++) {
			count[s.charAt(i) - 'a']++;
		}

		dfs(0);

		return res.get(0);
	}

	private static void dfs(int current) {
		if (check()) {
			res.add(new String(sb.toString()));
			return;
		}

		for (int i = current; i < 10; i++) {
			if (!isCanSub(map[i])) {
				continue;
			}

			sb.append(i);
			sub(map[i]);

			dfs(i);

			recover(map[i]);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static void sub(String num) {
		for (int i : num.toCharArray()) {
			count[i - 'a']--;
		}
	}

	private static boolean isCanSub(String num) {
		char[] ch = num.toCharArray();
		for (char i : ch) {
			if (count[i - 'a'] < 1) {
				return false;
			}
		}

		return true;
	}

	private static void recover(String num) {
		char[] ch = num.toCharArray();
		for (char c : ch) {
			count[c - 'a']++;
		}
	}

	private static boolean check() {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) {
				return false;
			}
		}

		return true;
	}

}
