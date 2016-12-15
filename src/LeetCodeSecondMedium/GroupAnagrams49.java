package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams49 {
	private int[] map = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<Integer, List<String>> m = new HashMap<Integer, List<String>>();

		for (String s : strs) {
			int key = 1;
			for (char ch : s.toCharArray()) {
				key *= map[ch - 'a'];
			}

			if (m.containsKey(key))
				m.get(key).add(s);
			else {
				m.put(key, new ArrayList<String>());
				m.get(key).add(s);
			}
		}

		List<List<String>> res = new ArrayList<List<String>>();
		for (Entry<Integer, List<String>> entry : m.entrySet()) {
			res.add(entry.getValue());
		}

		return res;
	}
}
