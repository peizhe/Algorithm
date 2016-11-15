package Algorithm;
/**
 * 将一个十进制数转换成其他进制数:
 * 	1.如果其他进制不是2的幂进制，欧几里得方法
 * 	2.如果其他进制是2的幂进制，下面方法
 * 
 * @author MG
 *
 */
public class NumTranslate {
	final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
	
	/**
	 * 
	 * 
	 * @param i 要转换的数
	 * @param shift 其他进制
	 * @return
	 */
	private static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits[i & mask];
            i >>>= shift;
        } while (i != 0);

        return new String(buf, charPos, (32 - charPos));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(toUnsignedString(100, 4));
	}

}
