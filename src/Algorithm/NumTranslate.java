package Algorithm;
/**
 * ��һ��ʮ������ת��������������:
 * 	1.����������Ʋ���2���ݽ��ƣ�ŷ����÷���
 * 	2.�������������2���ݽ��ƣ����淽��
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
	 * @param i Ҫת������
	 * @param shift ��������
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
