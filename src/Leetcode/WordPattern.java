package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		if(str.equals("")){
			return false;
		}
		String[] s = str.split(" ");
		//如果匹配模式长度和字符串长度不同，则返回false
		if(pattern.length() != s.length){
			return false;
		}
		Map<Character,String> map = new HashMap<Character, String>();
		
		for(int i = 0;i < pattern.length();i ++){
			char key = pattern.charAt(i);
			String value = s[i];
			
			if(!map.containsKey(key)){
				if(map.containsValue(value)){
					return false;
				}
				map.put(key, value);
				continue;
			}
			
			String temp = map.get(key);
			if(!temp.equals(value)){
				return false;
			}
		}
		
		return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog dog dog dogs";
		System.out.println(wordPattern(pattern,str));
	}
}
