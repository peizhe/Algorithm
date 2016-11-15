package LeetCodeSecondMedium;

public class IntegerToRoman12 {
	public static String intToRoman(int num) {  
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
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0){
        	sb.insert(0, roman[index ++][num % 10]);
        	num /= 10;
        }
        
        return sb.reverse().toString();
	}
	
	public static void main(String[] mh){
		System.out.println(intToRoman(20));
	}
}
