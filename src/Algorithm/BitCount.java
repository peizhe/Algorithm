package Algorithm;
/**
 * 
 * @author MG
 *
 */
public class BitCount {
	/**
	 * 计算一个整数中二进制表示中1的个数
	 * @param i
	 * @return
	 */
	public static int bitCount(int i){
		i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
	}
	
	/**
	 * 整数i二进制表示尾部0的个数
	 * @param i
	 * @return
	 */
	public static int numberOfTrailingZeros(int i) {
        int y;
        if (i == 0) return 32;
        int n = 31;
        y = i << 16; if (y != 0) { n = n - 16; i = y;}
        y = i << 8;  if (y != 0) { n = n - 8;  i = y;}
        y = i << 4;  if (y != 0) { n = n - 4;  i = y;}
        y = i << 2;  if (y != 0) { n = n - 2;  i = y;}
        
        return n - ((i << 1) >>> 31);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitCount(1000000000));
	}

}
