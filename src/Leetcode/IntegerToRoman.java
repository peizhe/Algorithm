package Leetcode;
/**
 * ������������һ�֣��������������ֲ���Ϥ�ͱȽϿ����
 * @author MG
 *
 */

public class IntegerToRoman {
	public String intToRoman(int num) {  
        String[][] roman = {  
        	//�����λ
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            //����ʮλ
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            //�����λ
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            //����ǧλ
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
