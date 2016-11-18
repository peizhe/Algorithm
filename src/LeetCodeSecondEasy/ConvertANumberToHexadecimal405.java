package LeetCodeSecondEasy;

public class ConvertANumberToHexadecimal405 {
	
	public static String toHex(int num) {
		if(num == 0) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
        while(num != 0) {
        	sb.append(map[num & 15]);
        	num >>>= 4;
        }
        
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toHex(-1));
	}

}
