package Leetcode;

public class RomanToInteger {
	public int romanToInt(String s) {
		int result = getRomanValue(s.charAt(0));
        for(int i = 1;i < s.length();i ++){
        	if(getRomanValue(s.charAt(i - 1)) < getRomanValue(s.charAt(i))){
        		//这里减的是2倍，因为前面加了一次，本来该减掉，所以这里减2次
        		result += getRomanValue(s.charAt(i)) - 2 * getRomanValue(s.charAt(i - 1));
        	}
        	else{
        		result += getRomanValue(s.charAt(i));
        	}
        }
        
        return result;
    }
	
	private int getRomanValue(char c){
		switch(c){
			case 'I': return 1;  
	        case 'V': return 5;  
	        case 'X': return 10;  
	        case 'L': return 50;  
	        case 'C': return 100;  
	        case 'D': return 500;  
	        case 'M': return 1000;
		}
		return 0;
	}
}
