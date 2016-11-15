package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        
        //用于存储字符串s和字符串t的映射关系
        Map<Character,Character> map = new HashMap<Character,Character>();
        //存储t字符串中的每个字符
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0;i < schar.length;i ++){
        	//如果前面的映射关系中已存在schar[i]映射
        	if(map.containsKey(schar[i])){
        		//比较前面存储schar[i]映射的字符与此时tchar[i]是否相同
        		//不相同则返回false
        		if(map.get(schar[i]) != tchar[i]){
        			return false;
        		}
        	}
        	//不包含schar[i]的映射关系
        	else{
        		//如果set中存在了tchar[i],证明前面tchar[k]已经对应一个schar[k]
        		//证明当前schar[i]与schar[k]对应一个tchar[k]
        		if(set.contains(tchar[i])){
        			return false;
        		}
        		//set中不存在tchar[i]
        		else{
        			map.put(schar[i],tchar[i]);
        			set.add(tchar[i]);
        		}
        	}
        }
        
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
