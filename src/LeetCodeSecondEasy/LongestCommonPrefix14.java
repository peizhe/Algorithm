package LeetCodeSecondEasy;

import java.util.Arrays;
/**
 * 找出所有字符串的最长公共前缀
 * 	1.找出数组中长度最短的字符串，然后截取0-index作为前缀(二重循环)
 * 	2.先对字符串排序，获得第一个和最后一个字符串，比较两个字符串的最长公共前缀(速度比较快，主要排序优化了)
 * 	3.找出数组中长度最短的字符串，从首字母进行遍历，所有字符串对应位置都有这个字符，则进行下一轮，否则结束(二重循环)
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
