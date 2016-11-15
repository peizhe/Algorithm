package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 这么简单的一道题！！！！！(想什么呢,和数是一样的)
 * 
 * 单词是可以重复使用的
 * 
 * @author MG
 *
 */
public class WordBreak139 {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}
	
	
	/**
	 * 看看人家怎么写的dfs,增加了记忆功能,自己写的没写记忆功能
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static boolean wordBreakDFS(String s, Set<String> wordDict) {
	    return dfs(s, wordDict, new HashSet<String>());
	}

	private static boolean dfs(String s, Set<String> wordDict, Set<String> checked) {
	    if (s.isEmpty()) return true;
	    if (checked.contains(s)) return false;
	    
	    //记录已经判断过的字符串(加入到这里面的字符串都是没有匹配成功的)
	    checked.add(s);
	    
	    for (String w : wordDict) {
	        if (s.startsWith(w) && dfs(s.substring(w.length()), wordDict, checked)) return true;
	    }
	    
	    return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "aa";
		Set<String> set = new HashSet<String>();
		set.add("a");
		System.out.println(wordBreakDFS(s,set));
	}

}
