package Leetcode;

import java.util.*;
/**
 * 寻找字符串数组中能组成回文字符传的字符串下标
 * 	Given words = ["bat", "tab", "cat"]
 *  Return [[0, 1], [1, 0]]
 *  
 *  思路：
 *  	1.用一个HashMap存储字符串数组中的单词(键为字符串，值为下标)
 *  	2.对于每一个单词进行切分  str1 = word.split(0,j) str2 = word.split(j)
 *  		如果str1是一个回文子串，则查询str2的反转字符串是否存在：
 *  			如果存在，则reverse(str2) + str1 + str2 就是一个回文串
 *  			如果不存在，则不能构成回文串
 *  		如果str2是一个回文子串，则查询str1的反转字符串是否存在：
 *  			如果存在，则str1 + str2 + reverse(str1)就是一个回文串
 *  			如果不存在，这不能构成回文串
 * @author MG
 *
 */
public class PalindromePairs336 {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
        if(words == null || words.length < 2){
        	return res;
        }
        
        int len = words.length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0;i < len;i ++) {
        	map.put(words[i], i);
        }
        
        for(int i = 0;i < len;i ++) {
        	int size = words[i].length();
        	for(int j = 0;j <= size;j ++) {
        		String str1 = words[i].substring(0, j);
        		String str2 = words[i].substring(j);
        		addPair(map, res, str1, str2, i, false);
        		if(str2.length() != 0){//如果str2的长度为0,添加的话会重复
        			//注意str2与str1进行了交换
        			addPair(map, res, str2, str1, i, true);
        		}
        	}
        }
        
        return res;
    }
	
	private void addPair(Map<String, Integer> map, List<List<Integer>> res, String str1, String str2, int index, boolean reverse){
		if(isPalindrome(str1)){
			String str2rev = new StringBuilder(str2).reverse().toString();
			if(map.containsKey(str2rev) && map.get(str2rev) != index){
				List<Integer> list = new ArrayList<Integer>();
				if(!reverse){
					list.add(map.get(str2rev));
					list.add(index);
				} else {
					list.add(index);
					list.add(map.get(str2rev));
				}
				
				res.add(list);
			}
		} 
	}
	
	private boolean isPalindrome(String s){
		char[] ch = s.toCharArray();
		int begin = 0, end = ch.length - 1;
		while(begin < end){
			if(ch[begin] != ch[end]){
				return false;
			}
			begin ++;
			end --;
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
