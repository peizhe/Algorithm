package LeetCodeSecondEasy;

import java.util.Arrays;
/**
 * �ҳ������ַ����������ǰ׺
 * 	1.�ҳ������г�����̵��ַ�����Ȼ���ȡ0-index��Ϊǰ׺(����ѭ��)
 * 	2.�ȶ��ַ������򣬻�õ�һ�������һ���ַ������Ƚ������ַ����������ǰ׺(�ٶȱȽϿ죬��Ҫ�����Ż���)
 * 	3.�ҳ������г�����̵��ַ�����������ĸ���б����������ַ�����Ӧλ�ö�������ַ����������һ�֣��������(����ѭ��)
 * @author MG
 *
 */

public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) return null;
	    if (strs.length == 0) return "";
	    
	    Arrays.sort(strs);
	    char[] first = strs[0].toCharArray();
	    char[] last  = strs[strs.length - 1].toCharArray();
	     
	    int i = 0, len = Math.min(first.length, last.length);
	    while (i < len && first[i] == last[i]) i++;
	    return strs[0].substring(0, i);
    }
}
