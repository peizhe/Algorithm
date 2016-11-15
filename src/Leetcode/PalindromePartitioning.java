package Leetcode;

import java.util.ArrayList;
import java.util.List;

//回文字符串划分  
//动态规划生成回文字符串数组  
//根据数组用深度搜索生成回文字符串的划分

public class PalindromePartitioning {
	//生成标志回文字符串的数组，partitioning_map[i][j] = 1的话，表明：string[i..j]是一个回文字符串
	//如果s.charAt(i) == s.charAt(j)，partitioning_map[i + 1][j - 1] = 1，则partitioning_map[i][j] = 1
	//得到的这个dp[][]是一个上三角阵，下三角都是0，对角线都是1
    public void dp(String s, byte[][] palindrome_map) {  
        for(int i = s.length() - 1;i >= 0;i --) {  
            for(int j = i;j < s.length();j ++) {  
                if(i == j) {  
                    palindrome_map[i][j] = 1;  
                } 
                else {  
                    if(s.charAt(i) == s.charAt(j)) {  
                        if(j == i + 1 || palindrome_map[i + 1][j - 1]== 1) {  
                            palindrome_map[i][j] = 1;  
                        }  
                    }  
                }  
            }  
        }  
    }  
    
    //根据生成好的回文标记数组对字符串进行划分  
    public void dfs(String s, int begin, byte[][] palindrome_map, ArrayList<String> array, List<List<String>> result) {  
        if(begin == s.length()) {  
            result.add(array);  
            return;  
        }  
          
        for(int i = begin;i < s.length();i ++) {  
            if(palindrome_map[begin][i] == 1) {  
                ArrayList<String> tmp = new ArrayList<String>(array);  
                tmp.add(s.substring(begin,i + 1));  
                dfs(s,i + 1,palindrome_map,tmp,result);  
            }  
        }  
    }  
    
    public List<List<String>> partition(String s) {  
        List<List<String>> result = new ArrayList<List<String>>();  
        ArrayList<String> array = new ArrayList<String>();  
  
        if(s == null || s.length() == 0) {  
            result.add(array);  
            return result;  
        }  
        byte[][] palindrome_map = new byte[s.length()][s.length()];  
          
        dp(s, palindrome_map);  
        dfs(s,0,palindrome_map,array,result);  
        return result;  
    } 
}
