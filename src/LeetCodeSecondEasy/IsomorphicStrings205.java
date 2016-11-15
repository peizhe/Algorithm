package LeetCodeSecondEasy;

import java.util.Arrays;
/**
 * �ж�һ�������ַ����Ƿ���ͬ���칹�ģ�
 * 	1.java�Դ�Mapʵ�֣������˸������ݽṹ����ʱ
 * 	2.�Լ����map��ͨ������ѭ���㶨��ʱ�临�Ӷ�O(n):�ռ临�Ӷ���С����ʱ��һ��
 * 	3.�Լ��������map��һ��ѭ���㶨��ʱ�临�Ӷ�O(n):ʱ�临�Ӷ���С�����Ƕ����˿ռ�
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
