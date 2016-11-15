package Leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * map的作用 : 举个例子
 * 	String s = "aabcabab";
 * 	Set set = {"a","abc","ab","bc"}
 * 	假设map("abab", List<String>)已经存在
 * 	则如果剩下的字符串再为"abab"时,则直接从map中拿出来
 * 		
 * 
 * @author MG
 *
 */
public class WordBreakII140 {
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, List<String>>());
	}

	private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		if(s.isEmpty()){
			return Collections.singletonList("");
		}

		List<String> res = new LinkedList<String>();
		
		for (String str : wordDict) {
			if (s.startsWith(str)) {
				List<String> subRes = dfs(s.substring(str.length()), wordDict, map);
				
				for(String sub : subRes){
					res.add(str + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		
		map.put(s, res);
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
