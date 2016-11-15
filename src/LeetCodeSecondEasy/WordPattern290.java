package LeetCodeSecondEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordPattern290 {
	public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        char[] ch = pattern.toCharArray();
        
        String[] map = new String[26];
        Arrays.fill(map, "");
        
        if(strs.length != ch.length){
        	return false;
        }
        
        int len = ch.length;
        int key;
        for(int i = 0;i < len;i ++){
        	key = ch[i] - 'a';
        	if(map[key] == ""){
        		map[key] = strs[i];
        	} else if(!map[key].equals(strs[i])){
        		return false;
        	}
        }
        
        Set<String> setString = new HashSet<String>();
        for(String s : strs){
        	setString.add(s);
        }
        
        Set<Character> setChar = new HashSet<Character>();
        for(char c : ch){
        	setChar.add(c);
        }
        
        return setString.size() == setChar.size();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String word = "dog cat cat dog";
		System.out.println(wordPattern(pattern, word));
	}

}
