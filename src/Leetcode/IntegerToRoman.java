package Leetcode;
/**
 * 这算是设计题的一种，不过对罗马数字不熟悉就比较苦逼了
 * @author MG
 *
 */

public class IntegerToRoman {
	public String intToRoman(int num) {  
        String[][] roman = {  
        	//代表个位
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            //代表十位
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            //代表百位
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            //代表千位
            {"", "M", "MM", "MMM"}  
        };  
          
        String ret = "";  
        int digit = 0;  
        while (num != 0) {  
            int remain = num % 10;  
            ret = roman[digit][remain] + ret;  
            digit ++;  
            num /= 10;  
        }  
          
        return ret;  
    }  
}
