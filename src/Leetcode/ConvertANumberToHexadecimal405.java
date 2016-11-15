package Leetcode;

public class ConvertANumberToHexadecimal405 {
	final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' };
	
	public String toHex(int num) {
		char[] buf = new char[8];
        int charPos = 8;
        int radix = 1 << 4;
        //mask : 1111
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[num & mask];
            num >>>= 4;
        } while (num != 0);
        
        return new String(buf, charPos, (8 - charPos));
    }
}
