package LeetCodeSecondEasy;

import java.util.Arrays;
/**
 * 判断一个两个字符串是否是同形异构的：
 * 	1.java自带Map实现：运用了复杂数据结构，耗时
 * 	2.自己设计map，通过两次循环搞定：时间复杂度O(n):空间复杂度最小，耗时多一点
 * 	3.自己设计两个map，一次循环搞定：时间复杂度O(n):时间复杂度最小，但是多用了空间
 * @author MG
 *
 */
public class IsomorphicStrings205 {
	public static boolean isIsomorphicSecond(String s, String t) {
		if(s == null && t == null){
			return true;
		}
		
		if(s == null || t == null || s.length() != t.length()){
			return false;
		}
		
		int[] map1 = new int[256];
		int[] map2 = new int[256];
		Arrays.fill(map1, -1);
		Arrays.fill(map2, -1);
		
		int len = s.length();
		
		for(int i = 0;i < len;i ++){
			if(map1[s.charAt(i)] != map2[t.charAt(i)]){
				return false;
			}
			
			map1[s.charAt(i)] = map2[t.charAt(i)] = i;
		}
		
		return true;
	}
	
	public static boolean isIsomorphic(String s, String t) {
		if(s == null && t == null){
			return true;
		}
		
		if(s == null || t == null || s.length() != t.length()){
			return false;
		}
		
		int[] stmap = new int[256];
		int[] tsmap = new int[256];
		Arrays.fill(stmap, -1);
		Arrays.fill(tsmap, -1);
		
		int len = s.length();
		
		int s1;
		int t1;
		
		for(int i = 0;i < len;i ++){
			s1 = s.charAt(i);
			t1 = t.charAt(i);
			if(stmap[s1] == -1 && tsmap[t1] == -1){
				stmap[s1] = t1;
				tsmap[t1] = s1;
			} else if(stmap[s1] != t1 || tsmap[t1] != s1){
				return false;
			}		
		}
		
        return true;
    }
	
	public static void main(String[] mh){
		System.out.println(isIsomorphic("abbc", "gffd"));
	}
}
