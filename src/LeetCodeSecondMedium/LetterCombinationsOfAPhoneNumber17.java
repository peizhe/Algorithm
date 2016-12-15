package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
	List<String> result = new ArrayList<String>();

	public List<String> letterCombinationsBetter(String digits) {
		if (digits == null || digits.length() == 0) {
			return result;
		}
		
		dfs(digits, 0, new StringBuilder());

		return result;
	}

	public void dfs(String digits, int current, StringBuilder sb) {
		if (current == digits.length()) {
			result.add(sb.toString());
			return;
		}

		// 得到当前数字对应的字符串
		String num2StringCurrent = num2String(digits.charAt(current));
		// 循环遍历当前数字对应的字符
		for (int j = 0; j < num2StringCurrent.length(); j++) {
			sb.append(num2StringCurrent.charAt(j));
			dfs(digits, current + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public String num2String(char num) {
		switch (num) {
			case '2':
				return "abc";
			case '3':
				return "def";
			case '4':
				return "ghi";
			case '5':
				return "jkl";
			case '6':
				return "mno";
			case '7':
				return "pqrs";
			case '8':
				return "tuv";
			case '9':
				return "wxyz";
			default:
				return "";
		}
	}

	char[][] map = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
			{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.trim().length() == 0)
			return new ArrayList<String>();

		int len = digits.length();
		List<String> res = new ArrayList<String>();

		for (int i = 0; i < map[digits.charAt(0) - '0'].length; i++) {
			res.add(map[digits.charAt(0) - '0'][i] + "");
		}

		for (int i = 1; i < len; i++) {
			res = helper(res, map[digits.charAt(i) - '0']);
		}

		return res;
	}

	private List<String> helper(List<String> origin, char[] nums) {
		List<String> res = new ArrayList<String>();

		for (String s : origin) {
			for (int i = 0; i < nums.length; i++) {
				res.add(s + nums[i]);
			}
		}

		return res;
	}
}
