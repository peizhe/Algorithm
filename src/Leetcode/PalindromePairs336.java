package Leetcode;

import java.util.*;
/**
 * Ѱ���ַ�������������ɻ����ַ������ַ����±�
 * 	Given words = ["bat", "tab", "cat"]
 *  Return [[0, 1], [1, 0]]
 *  
 *  ˼·��
 *  	1.��һ��HashMap�洢�ַ��������еĵ���(��Ϊ�ַ�����ֵΪ�±�)
 *  	2.����ÿһ�����ʽ����з�  str1 = word.split(0,j) str2 = word.split(j)
 *  		���str1��һ�������Ӵ������ѯstr2�ķ�ת�ַ����Ƿ���ڣ�
 *  			������ڣ���reverse(str2) + str1 + str2 ����һ�����Ĵ�
 *  			��������ڣ����ܹ��ɻ��Ĵ�
 *  		���str2��һ�������Ӵ������ѯstr1�ķ�ת�ַ����Ƿ���ڣ�
 *  			������ڣ���str1 + str2 + reverse(str1)����һ�����Ĵ�
 *  			��������ڣ��ⲻ�ܹ��ɻ��Ĵ�
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
        		if(str2.length() != 0){//���str2�ĳ���Ϊ0,��ӵĻ����ظ�
        			//ע��str2��str1�����˽���
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
