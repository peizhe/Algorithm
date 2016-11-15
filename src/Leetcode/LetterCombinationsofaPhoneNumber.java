package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	
	List<String> result = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
        	return result;
        }
        String temp = "";
        dfs(digits,0,temp);
        
        return result;
    }
	
	public void dfs(String digits,int current,String temp){
		if(current == digits.length()){
			result.add(temp);
			return;
		}
		
		//得到当前数字对应的字符串
		String num2StringCurrent = num2String(digits.charAt(current));
		//循环遍历当前数字对应的字符
		for(int j = 0;j < num2StringCurrent.length();j ++){
			temp += num2StringCurrent.charAt(j);
			dfs(digits,current + 1,temp);
			temp = temp.substring(0,temp.length() - 1);
		}
	}
	
	public String num2String(char num){
		switch(num){
			case '2':
				return "abc";
			case '3':
				return "def";
			case '4':
				return "ghi";
			case '5':
				return "jkl";
			case '6':
				return "mno";
			case '7':
				return "pqrs";
			case '8':
				return "tuv";
			case '9':
				return "wxyz";
			default:
				return "";
		}
	}
}
