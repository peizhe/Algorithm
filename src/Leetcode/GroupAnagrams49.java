package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将具有相同字符的字符串放在一个里面
 * 
 * 
 * @author MG
 * 
 */
public class GroupAnagrams49 {

	/**
	 * 传统的思想 
	 * 	题目没要求按字典序输出
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			
			map.get(keyStr).add(s);
		}
		
		return new ArrayList<List<String>>(map.values());
	}

	/**
	 * 用质数的方法表示字母 (很创新的思想)
	 */
	public static List<List<String>> groupAnagramsPrime(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53,
				59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };// 最多10609个z
		List<List<String>> res = new ArrayList<List<String>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<String>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = groupAnagrams(strs);

		for (List<String> str : res) {
			for (String s : str) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

}
