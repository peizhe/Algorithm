package LeetCodeSecondEasy;
/**
 * 判断一个数是不是2的幂：
 * 	 1.x & (x - 1) 如果为0，则是2的幂，否则不是！根据二进制计算
 * @author MG
 *
 */
public class PowerofTwo231 {
	public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
