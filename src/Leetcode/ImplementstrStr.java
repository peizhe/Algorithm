package Leetcode;

public class ImplementstrStr {
	
	//运用KMP方法（http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html）
	public String strStr1(String haystack, String needle) {  
        return null;
    }  
	
	//这是一种方法！
	public static String strStr(String haystack, String needle) {  
        if(haystack.length() <= 0) 
        	return null;
        int res = 0;
        res = haystack.indexOf(needle);  
        if(res == -1) 
        	return null;  
        else{  
            return haystack.substring(res);  
        }
    }  
	
	public static void main(String[] mh){
		String hay = "abcdefg";
		String needle = "bc";
		System.out.println(strStr(hay, needle));
	}
}
