package LeetCodeSecondMedium;

public class IntegerToRoman12 {
	public static String intToRoman(int num) {  
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
