package Leetcode;

import java.util.ArrayList;
import java.util.List;

//�����ַ�������  
//��̬�滮���ɻ����ַ�������  
//��������������������ɻ����ַ����Ļ���

public class PalindromePartitioning {
	//���ɱ�־�����ַ��������飬partitioning_map[i][j] = 1�Ļ���������string[i..j]��һ�������ַ���
	//���s.charAt(i) == s.charAt(j)��partitioning_map[i + 1][j - 1] = 1����partitioning_map[i][j] = 1
	//�õ������dp[][]��һ���������������Ƕ���0���Խ��߶���1
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
    
    //�������ɺõĻ��ı��������ַ������л���  
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
